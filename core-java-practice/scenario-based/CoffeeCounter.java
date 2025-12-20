import java.util.*;
public class CoffeeCounter {
    public static void main(String args[]){
        Scanner ob=new Scanner(System.in);
        while (true) { 
            double price=0.0;
            System.out.println("Enter the Coffee Type you want");
            String type=ob.next();
            if(type.equals("exit"))
                break;
            else{
                switch(type){
                    case "Latte": price=120;
                    break;
                    case "Cappuccino": price=150;
                    break;
                    case "Espresso":price=100;
                    break;
                    default:System.out.println("Enter the valid Coffee type (Latte, Cappuccino, Espresso).");
                }
                System.out.println("Enter the Quantity");
                int qty=ob.nextInt();
                Double amount=price*qty;
                Double gst=amount*0.05;
                Double total=gst+amount;
                System.out.println("Total Payable Bill : "+total);
            }
        }
    }
}
