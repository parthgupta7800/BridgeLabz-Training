class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;
    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class SavingsAccount extends BankAccount {
    SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber); 
        System.out.println("Account Holder: " + accountHolder); 
        System.out.println("Balance: " + getBalance());  
    }
}
public class BankAccountSystem {
    public static void main(String[] args) {
        SavingsAccount account =new SavingsAccount("ACC1214", "Parth", 95000);
        account.displayAccountDetails();
        account.setBalance(7500);
        System.out.println("Updated Balance: " + account.getBalance());
    }
}
