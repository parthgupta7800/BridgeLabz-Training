import java.util.*;
class PaymentFailedException extends Exception{
    PaymentFailedException(String message){
        super(message);
    }
}
interface Payment{
    void pay(double amount)throws PaymentFailedException;
}
class CardPayment implements Payment{
    public void pay(double amount)throws PaymentFailedException{
        if(amount<=0){
            throw new PaymentFailedException("Invalid payment amount");
        }
        System.out.println("Payment successful via Card:"+amount);
    }
}
class UPIPayment implements Payment{
    public void pay(double amount)throws PaymentFailedException{
        System.out.println("Payment successful via UPI:"+amount);
    }
}
class WalletPayment implements Payment{
    public void pay(double amount)throws PaymentFailedException{
        if(amount>5000){
            throw new PaymentFailedException("Wallet limit exceeded");
        }
        System.out.println("Payment successful via Wallet:"+amount);
    }
}
class Product{
    int productId;
    String productName;
    double price;
    Product(int productId,String productName,double price){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
    }
    void display(){
        System.out.println("Product ID:"+productId);
        System.out.println("Product Name:"+productName);
        System.out.println("Product Price:"+price);
    }
}
class Cart{
    int productId;
    String productName;
    int qty;
    double price;
    public Cart(int productId,String productName,int qty,double price){
        this.productId=productId;
        this.productName=productName;
        this.qty=qty;
        this.price=price;
    }
    double getTotal(){
        return price*qty;
    }
    void displayCart(){
        System.out.println("Product ID:"+productId);
        System.out.println("Product Name:"+productName);
        System.out.println("Quantity:"+qty);
        System.out.println("Price:"+(price*qty));
    }
}
class Order{
    int orderId;
    double bill;
    String status;
    Order(int orderId,double bill){
        this.orderId=orderId;
        this.bill=bill;
        this.status="true";
    }
    void displayBill(){
        System.out.println("Order ID:"+orderId);
        System.out.println("Total bill:"+bill);
        System.out.println("Status:"+status);
    }
}
class ProductManager{
    ArrayList<Product> products=new ArrayList<>();
    ArrayList<Cart> cart=new ArrayList<>();
    Order order;
    int orderId=1;
    void add(Product p){
        products.add(p);
    }
    void catalog(){
        for(int i=0;i<products.size();i++){
            products.get(i).display();
        }
    }
    void addCart(int productId,String productName,int qty,double price){
        cart.add(new Cart(productId,productName,qty,price));
    }
    void viewCart(){
        for(int i=0;i<cart.size();i++){
            cart.get(i).displayCart();
        }
    }
    double calculateBill(){
        double total=0;
        for(int i=0;i<cart.size();i++){
            total+=cart.get(i).getTotal();
        }
        return total;
    }
    void placeOrder(Payment payment){
        double bill=calculateBill();
        try{
            payment.pay(bill);
            order=new Order(orderId++,bill);
            order.displayBill();
            cart.clear();
        }
        catch(PaymentFailedException e){
            System.out.println(e.getMessage());
        }
    }
    void trackOrder(){
    if(order==null){
        System.out.println("No order placed yet");
        return;
    }
    order.displayBill();
}
    void cancelOrder(){
        if(order==null){
            System.out.println("No order to cancel");
            return;
        }
        order.status="CANCELLED";
        System.out.println("Order cancelled");
}
}
public class ECommerce{
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        System.out.println("Welcome to this E-Commerce Order Management System");
        boolean loop=true;
        ProductManager manager=new ProductManager();
        manager.add(new Product(1,"Asus Laptop",66000));
        manager.add(new Product(2,"Lenovo Laptop",45000));
        manager.add(new Product(3,"Dell Laptop",56000));
        manager.add(new Product(4, "Portronics mouse",300));
        manager.add(new Product(5, "Laptop bag", 1200));
        while(loop){
            System.out.println("Enter 1 to view the catalog");
            System.out.println("Enter 2 to add products to cart");
            System.out.println("Enter 3 to view the cart");
            System.out.println("Enter 4 to place order");
            System.out.println("Enter 5 to track order");
            System.out.println("Enter 6 to cancel order");
            System.out.println("Enter 0 to exit this system");
            int choice=ob.nextInt();
            switch(choice){
                case 1:
                    manager.catalog();
                    break;
                case 2:
                    System.out.println("Enter the product ID to add to cart");
                    int id=ob.nextInt();
                    System.out.println("Enter the quantity");
                    int qty=ob.nextInt();
                    for(int i=0;i<manager.products.size();i++){
                        if(manager.products.get(i).productId==id){
                            manager.addCart(id,manager.products.get(i).productName,qty,manager.products.get(i).price);
                        }
                    }
                    System.out.println("Successfully added to cart!!");
                    break;
                case 3:
                    manager.viewCart();
                    break;
                case 4:
                    System.out.println("Enter payment method:1.Card 2.UPI 3.Wallet");
                    int pay=ob.nextInt();
                    Payment payment=null;
                    if(pay==1)payment=new CardPayment();
                    if(pay==2)payment=new UPIPayment();
                    if(pay==3)payment=new WalletPayment();
                    manager.placeOrder(payment);
                    break;
                case 5:
                    manager.trackOrder();
                    break;
                case 6:
                    manager.cancelOrder();
                    break;
                case 0:
                    loop=false;
                    System.out.println("Thank you");
                    break;
            }
        }
    }
}