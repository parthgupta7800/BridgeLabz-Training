class Product{
    static double discount=10.0;
    final String productID;
    String productName;
    double price;
    int quantity;
    Product(String productID,String productName,double price,int quantity){
        this.productID=productID;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;
    }
    static void updateDiscount(double d){
        discount=d;
    }
    void display(Object obj){
        if(obj instanceof Product){
            double finalPrice=price-(price*discount/100);
            System.out.println("Product ID: "+productID);
            System.out.println("Product Name: "+productName);
            System.out.println("Price:"+price);
            System.out.println("Quantity: "+quantity);
            System.out.println("Discount: "+discount+"%");
            System.out.println("Price after Discount: "+finalPrice);
        }
    }
    public static void main(String[] args){
        Product p1=new Product("001","Laptop",1200.0,5);
        Product p2=new Product("002","Smartphone",800.0,10);
        p1.display(p1);
        System.out.println();
        p2.display(p2);
    }
}
