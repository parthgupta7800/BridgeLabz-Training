class Order{
    String orderId;
    String orderDate;
    Order(String orderId,String orderDate){
        this.orderId=orderId;
        this.orderDate=orderDate;
    }
    String getOrderStatus(){
        return "Order Placed";
    }
}
class ShippedOrder extends Order{
    String trackingNumber;
    ShippedOrder(String orderId,String orderDate,String trackingNumber){
        super(orderId,orderDate);
        this.trackingNumber=trackingNumber;
    }
    @Override
    String getOrderStatus(){
        return "Order Shipped";
    }
}
class DeliveredOrder extends ShippedOrder{
    String deliveryDate;
    DeliveredOrder(String orderId,String orderDate,String trackingNumber,String deliveryDate){
        super(orderId,orderDate,trackingNumber);
        this.deliveryDate=deliveryDate;
    }
    @Override
    String getOrderStatus(){
        return "Order Delivered";
    }
}
public class OrderTest{
    public static void main(String[] args){
        Order o=new DeliveredOrder("ORD1","01-01","TR123","05-01");
        System.out.println(o.getOrderStatus());
    }
}
