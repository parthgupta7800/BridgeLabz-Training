import java.util.*;
public class Question1 {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        int n=ob.nextInt();
        ob.nextLine();
        for(int i=0;i<n;i++){
            String str=ob.nextLine();
            String s[]=str.split("\\|");
            if(code(s[0])&&date(s[1])&&mode(s[2])&&weight(s[3])&&status(s[4])){
                System.out.println("COMPLIANT RECORD");
            }
            else System.out.println("NON-COMPLIANT RECORD");
        }
    }
    public static boolean code(String shipmentCode){
        String regex=("^SHIP-[1-9]{1}(?!.*(\\d)\\1{3,})\\d{5}$");
        return shipmentCode.matches(regex);
    }
    
    public static boolean date(String validateDate){

        String pattern[]=validateDate.split("-");
        int month=Integer.parseInt(pattern[1]);
        int date=Integer.parseInt(pattern[2]);
        int year=Integer.parseInt(pattern[0]);

        if(year<2000||year>2099)
            return false;

        if(month<1||month>12)
            return false;

        if(month==2){
            if((year%4==0&&year%100!=0)||year%400==0){
                return date>=1&&date<=29;
            }
            else{
                return date>=1&&date<=28;
            }
        }

        if(month==4||month==6||month==9||month==11){
            return date>=1&&date<=30;
        }

        return date>=1&&date<=31;
    }

    public static boolean mode(String mode){
        String regex="(AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT)";
        return mode.matches(regex);
    }

    public static boolean weight(String weight){
        String regex="^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$";
        return weight.matches(regex);
    }

    public static boolean status(String status){
        String regex="(DELIVERED|CANCELLED|IN_TRANSIT)";
        return status.matches(regex);
    }
}
