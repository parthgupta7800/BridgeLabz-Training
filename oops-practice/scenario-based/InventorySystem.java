import java.util.*;
interface AlertService{
    void sendAlert(String message);
}
class OutOfStockException extends Exception{
    OutOfStockException(String message){
        super(message);
    }
}
class Product{
    int productId;
    String productName;
    int qty;
    Product(int productId,String productName,int qty){
        this.productId=productId;
        this.productName=productName;
        this.qty=qty;
    }
    void displayProduct(){
        System.out.println("Product ID:"+productId);
        System.out.println("Product Name:"+productName);
        System.out.println("Quantity:"+qty);
    }
}
class Inventory implements AlertService{
    ArrayList<Product> products=new ArrayList<>();
    void addProduct(Product p){
        products.add(p);
        System.out.println("Product added");
    }
    void update(int id,int newQty)throws OutOfStockException{
        for(int i=0;i<products.size();i++){
            if(products.get(i).productId==id){
                if(newQty<0){
                    throw new OutOfStockException(
                        "Cannot reduce more than available stock for product:"+products.get(i).productName
                    );
                }
                products.get(i).qty=newQty;
                System.out.println("Stock Updated");
                if(newQty==0){
                    sendAlert("Product "+products.get(i).productName+" is out of stock");
                }
                return;
            }
        }
        System.out.println("Product not found");
    }
    void displayStock(){
        for(int i=0;i<products.size();i++){
            products.get(i).displayProduct();
        }
    }
    public void sendAlert(String message){
        System.out.println("ALERT:"+message);
    }
}
public class InventorySystem{
    public static void main(String[] args){
        Scanner ob=new Scanner(System.in);
        Inventory inventory=new Inventory();
        boolean loop=true;
        while(loop){
            System.out.println("Enter 1 to add product");
            System.out.println("Enter 2 to update stock");
            System.out.println("Enter 3 to display stock");
            System.out.println("Enter 0 to exit");
            int choice=ob.nextInt();
            ob.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter the product name");
                    String nameProduct=ob.nextLine();
                    System.out.println("Enter the quantity");
                    int qty=ob.nextInt();
                    inventory.addProduct(new Product(inventory.products.size()+1,nameProduct,qty));
                    break;
                case 2:
                    System.out.println("Enter the product id");
                    int id=ob.nextInt();
                    System.out.println("You want to 1.Add stock 2.Reduce stock");
                    int subChoice=ob.nextInt();
                    boolean found=false;
                    for(int i=0;i<inventory.products.size();i++){
                        if(inventory.products.get(i).productId==id){
                            found=true;
                            try{
                                if(subChoice==1){
                                    System.out.println("Enter quantity to add");
                                    int addQty=ob.nextInt();
                                    int updatedQty=inventory.products.get(i).qty+addQty;
                                    inventory.update(id,updatedQty);
                                }else if(subChoice==2){
                                    System.out.println("Enter quantity to reduce");
                                    int reduceQty=ob.nextInt();
                                    int updatedQty=inventory.products.get(i).qty-reduceQty;
                                    inventory.update(id,updatedQty);
                                }
                            }catch(OutOfStockException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Product not found");
                    }
                    break;
                case 3:
                    inventory.displayStock();
                    break;
                case 0:
                    loop=false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
