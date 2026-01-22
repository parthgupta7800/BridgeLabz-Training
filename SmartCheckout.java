import java.util.*;
class Customer{
    String name;
    List<String>items;  
    Customer(String name) {
        this.name=name;
        this.items=new ArrayList<>();
    }
}
class CheckoutSystem{
    Queue<Customer >queue=new LinkedList<>();
    HashMap<String,Integer> prices=new HashMap<>();
    HashMap<String,Integer> stock=new HashMap<>();
    public void addItem(String item,int price,int stock){
        prices.put(item,price);
        this.stock.put(item,stock);
    }
    public void addCustomer(String name){
        Customer customer=new Customer(name);
        queue.add(customer);
    }
    public void removeCustomer(){
        if(queue.isEmpty()){
            System.out.println("No customers in queue.");
            return;
        }
        Customer removed=queue.poll();
        System.out.println("Customer removed from queue: "+removed.name);
    }
    public void showQueue(){
        if(queue.isEmpty()){
            System.out.println("No customers in queue.");
            return;
        }
        System.out.println("Customers in queue:");
        for(Customer customer:queue){
            System.out.println("- "+customer.name);
        }
    }
    public void processNextCustomer(){
        if(queue.isEmpty()){
            System.out.println("No customers in queue.");
            return;
        }
        Customer customer=queue.poll();
        double total=0.0;
        System.out.println("Billing for customer: "+customer.name);
        for(String item:customer.items){
            if(prices.containsKey(item) && stock.get(item)>0){
                int price=prices.get(item);
                total+=price;
                stock.put(item,stock.get(item)-1);
                System.out.println(item+": "+price);
            }else{
                System.out.println(item+": Out of stock");
            }
        }
        System.out.println("Total bill amount: "+total);
    }
    public void showStock(){
        System.out.println("Current stock level:");
        for(Map.Entry<String,Integer>entry:stock.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
public class SmartCheckout {
    public static void main(String  args[]){
        Scanner ob=new Scanner(System.in);
        CheckoutSystem system=new CheckoutSystem();
        system.addItem("Apple",2,10);
        system.addItem("Banana",1,5);
        system.addItem("Orange",3,8);
        boolean exit=true;
        while(exit){
            System.out.println("1. Add Customer\n2. Remove Customer\n3. Show Queue\n4. Process Next Customer\n5. Show Stock\n6. Exit");
            System.out.println("Enter your choice:");
            int choice=ob.nextInt();
            ob.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter customer name:");
                    String name=ob.nextLine();
                    system.addCustomer(name);
                    System.out.println("Enter items (comma separated):");
                    String itemsLine=ob.nextLine();
                    String[] items=itemsLine.split(",");
                    Customer customer=new Customer(name);
                    for(String item:items){
                        customer.items.add(item.trim());
                    }
                    system.queue.removeIf(c -> c.name.equals(name));
                    system.queue.add(customer);
                    break;
                case 2:
                    system.removeCustomer();
                    break;
                case 3:
                    system.showQueue();
                    break;
                case 4:
                    system.processNextCustomer();
                    break;
                case 5:
                    system.showStock();
                    break;
                case 6:
                    exit=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
