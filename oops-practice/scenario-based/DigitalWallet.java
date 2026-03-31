import java.util.*;
class InsufficientBalanceException extends Exception{
    InsufficientBalanceException(String msg){
        super(msg);
    }
}
class Transaction{
    String type;
    double amount;
    Transaction(String type,double amount){
        this.type=type;
        this.amount=amount;
    }
    void display(){
        System.out.println(type+" : ₹"+amount);
    }
}
class Wallet{
    private double balance;
    private List<Transaction> history;
    Wallet(){
        balance=0;
        history=new ArrayList<>();
    }
    public void addMoney(double amount){
        balance+=amount;
        history.add(new Transaction("Credit",amount));
        System.out.println("Money added:₹"+amount);
    }
    public void withdrawMoney(double amount)throws InsufficientBalanceException{
        if(amount>balance)
            throw new InsufficientBalanceException("Insufficient Balance");
        balance-=amount;
        history.add(new Transaction("Debit",amount));
        System.out.println("Money withdrawn:₹"+amount);
    }
    public double getBalance(){
        return balance;
    }
    public void showHistory(){
        System.out.println("Transaction History:");
        for(Transaction t:history)
            t.display();
    }
}
class User{
    String name;
    Wallet wallet;
    User(String name){
        this.name=name;
        wallet=new Wallet();
    }
}
interface TransferService{
    void transfer(User from,User to,double amount)throws InsufficientBalanceException;
}
class WalletTransfer implements TransferService{
    public void transfer(User from,User to,double amount)throws InsufficientBalanceException{
        from.wallet.withdrawMoney(amount);
        to.wallet.addMoney(amount);
        System.out.println("Wallet to Wallet transfer successful");
    }
}
class BankTransfer implements TransferService{
    public void transfer(User from,User to,double amount)throws InsufficientBalanceException{
        from.wallet.withdrawMoney(amount);
        to.wallet.addMoney(amount);
        System.out.println("Bank transfer successful");
    }
}
public class DigitalWallet{
    public static void main(String[] args){
        User user1=new User("Parth");
        User user2=new User("Aman");
        TransferService walletTransfer=new WalletTransfer();
        TransferService bankTransfer=new BankTransfer();
        try{
            user1.wallet.addMoney(5000);
            walletTransfer.transfer(user1,user2,2000);
            bankTransfer.transfer(user2,user1,500);
        }catch(InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }
        System.out.println(user1.name+" Balance:₹"+user1.wallet.getBalance());
        user1.wallet.showHistory();
        System.out.println(user2.name+" Balance:₹"+user2.wallet.getBalance());
        user2.wallet.showHistory();
    }
}
