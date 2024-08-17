import java.util.Scanner;
interface Account{
    void deposit(double amount); 
 void withdraw(double amount);
 double getbalance();
  }
  abstract class BankAccount implements Account{
     protected double balance;
    protected BankAccount (double balance){
        this.balance=balance;

    }
    public void deposit(double amount){
        balance=balance+amount;
    }
    public void withdraw(double amount){
        balance=balance-amount;
  }
  public double getbalance(){
    return balance;
  }
}
class Saving_account extends BankAccount{
    protected Saving_account(double balance){
        super(balance);
    }
    private double intrestrate=0.05;
    void addInterest(){
        balance=balance+intrestrate;
    }
    
}
class CheckingAccount extends BankAccount{
    protected CheckingAccount(double balance){
    super(balance);
    }
    public void withdraw(double amount){
        balance=balance-amount;
        balance--;
    }
    
}
public class Banking_App1 {
    public static void main(String[] args){
        Saving_account s = new Saving_account(60000);
        CheckingAccount c=new CheckingAccount(60000);
        s.addInterest();
        Scanner sc = new Scanner(System.in);
       System.out.println("choose 1 to Deposit the amount");
       System.out.println("choose 2 to Withdraw the amount");
       int n=sc.nextInt();
       if(n==1){
        System.out.println("Enter the amount to deposit");
        int d =sc.nextInt();
        s.deposit(d);
        System.out.println("Amount in saving account is:" +s.getbalance());
       }
       if(n==2){
        System.out.println("Enter the amount to Withdraw");
        int w =sc.nextInt();
        c.withdraw(w);
        System.out.println("Amount in saving account is:" +s.getbalance());
       }
    }
}