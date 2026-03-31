import java.time.LocalDate;
import java.util.*;

class PaymentDeclinedException extends Exception{
    public PaymentDeclinedException(String message){
        super(message);
    }
}

interface DiscountStrategy{
    double applyDiscount(double amount);
}

class FestiveDiscount implements DiscountStrategy{
    public double applyDiscount(double amount){
        return amount-amount*0.20;
    }
}

class User{
    private String name;
    private LocalDate expiryDate;
    private boolean active;
    private double amount;

    public User(String name,LocalDate expiryDate,double amount){
        this.name=name;
        this.expiryDate=expiryDate;
        this.amount=amount;
        this.active=true;
    }

    public String getName(){
        return name;
    }

    public LocalDate getExpiryDate(){
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate){
        this.expiryDate=expiryDate;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active=active;
    }

    public double getAmount(){
        return amount;
    }
}

public class DigitalSubscriptionRenewalSystem{

    private List<User> users=new ArrayList<>();
    private DiscountStrategy strategy;

    public void setStrategy(DiscountStrategy strategy){
        this.strategy=strategy;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void renew()throws PaymentDeclinedException{
        for(User user:users){
            if(user.isActive()){
                if(user.getExpiryDate().isBefore(LocalDate.now())){
                    user.setActive(false);
                    System.out.println(user.getName()+" subscription expired");
                }else{
                    double finalAmount=strategy.applyDiscount(user.getAmount());
                    if(finalAmount<=0){
                        throw new PaymentDeclinedException("Payment failed for "+user.getName());
                    }
                    user.setExpiryDate(user.getExpiryDate().plusMonths(1));
                    System.out.println(user.getName()+" renewed successfully with amount "+finalAmount);
                }
            }
        }
    }

    public static void main(String[] args){
        DigitalSubscriptionRenewalSystem system=new DigitalSubscriptionRenewalSystem();
        system.setStrategy(new FestiveDiscount());

        system.addUser(new User("Parth",LocalDate.now().plusDays(3),500));
        system.addUser(new User("Rahul",LocalDate.now().minusDays(2),400));

        try{
            system.renew();
        }catch(PaymentDeclinedException e){
            System.out.println(e.getMessage());
        }
    }
}