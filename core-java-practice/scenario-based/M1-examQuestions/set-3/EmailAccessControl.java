import java.util.*;

public class EmailAccessControl {

    public static boolean validateEmail(String email) {
        String regex = "^[a-z]{3,}\\.[a-z]{3,}[0-9]{4,}@(sales|marketing|IT|product)\\.company\\.com$";
        return email.matches(regex);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String email = sc.nextLine();
            if(validateEmail(email)){
                System.out.println("Access Granted");
            }
            else{
                System.out.println("Access Denied");
            }
        }
        sc.close();
    }
}