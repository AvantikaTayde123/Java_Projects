import java.util.Scanner;

interface Account 
{
    void deposit(double deposit_amount);
    void withdraw(double withdraw_amount);  
    public double get_balance();
}
abstract class BankAccount implements Account
{
    protected double balance;
    protected BankAccount(double balance)
    {
        this.balance = balance;
    }
    public void deposit(double deposit_amount)
    {
        if(deposit_amount>0)
        {
            balance += deposit_amount;
            System.out.println("Rs."+ deposit_amount + " Deposit successful.");
        }
    }
    public void withdraw(double withdraw_amount)
    {
        if(withdraw_amount > 0 && withdraw_amount <= balance)
        {
            balance -= withdraw_amount;
            System.out.println("Rs." + withdraw_amount + " Withdrawal successful.");
        }
        else
        {
            System.out.println("Insufficient balance.");
        }
    }
    public double get_balance()
    {
        return balance;
    }
}
class SavingAccount extends BankAccount
{
    private final double interestRate;

    SavingAccount(double intialbalance, double interestRate)
    {
        super(intialbalance);
        this.interestRate = interestRate;
    }
    public void addInterest()
    {
        double Interest = (get_balance() * interestRate)/100;
        balance += Interest;
        System.out.println("Your annual interest is: Rs." + Interest);
        System.out.println("After including interst your new balance is: Rs." + balance);
    } 
}
class CheckingAccount extends BankAccount
{
    private static float TRANSACTION_FEE = 1.00f;

    protected CheckingAccount(double balance) 
    {
        super(balance);
    }
    public void withdraw(double withdraw_amount)
    {
        if(withdraw_amount > 0 && balance > withdraw_amount+TRANSACTION_FEE)
        {
            balance -= (withdraw_amount+TRANSACTION_FEE);
            System.out.println("Rs." + withdraw_amount + " Withdrawal successful.");
        }
        else
        {
            System.out.println("Insufficient balance.");
        }
    }
}
public class BankAccount_App
{
    public static void main(String[] args) 
    {
        System.out.println("Welcome");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your account number: ");
        String accountNumber = sc.nextLine();

        System.out.println("Choose your account type:");
        System.out.println("1. Current Account");
        System.out.println("2. Savings Account");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();

        BankAccount account = null;
        
        switch (choice) 
        {
            case 1:
                System.out.print("Enter initial balance for current account: Rs.");
                double currentBalance = sc.nextDouble();
                account = new CheckingAccount(currentBalance);       
                break;

            case 2:
                System.out.println("Enter initial balance for savings account: Rs.");
                double savingsBalance = sc.nextDouble();
                System.out.print("Enter annual interest rate for savings account (e.g., 0.05 for 5%): ");
                double interestRate = sc.nextDouble();
                account = new SavingAccount(savingsBalance, interestRate);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        boolean continueOperations = true;
        try
        {
            while (continueOperations==true) 
            {
                System.out.println("\nChoose operation:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance with annual interest");
                System.out.println("4. Exit");
                System.out.print("Enter your choice (1-4): ");

                int operationChoice = sc.nextInt();

                try 
                {
                    switch (operationChoice) 
                    {
                    case 1:
                        System.out.print("Enter amount to deposit: Rs.");
                        double deposit_amount = sc.nextDouble();
                        account.deposit(deposit_amount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: Rs.");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Balance of your account: Rs." + account.get_balance());
                        if(choice==2)
                        {
                            ((SavingAccount)account).addInterest();
                        }
                        break;
                    case 4:
                        continueOperations = false;
                        break;
                    default:
                        System.out.println("Invalid choice..");
                    }
                } 
                catch (Exception e) 
                {
                    System.out.println("Invalid input Please try again");
                }
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Do you want to see your balance? (yes/no): ");
                String response = sc2.nextLine();
                if(response.equalsIgnoreCase("yes"))
                {
                    System.out.println("Your balance: Rs." + account.get_balance());
                }
                System.out.print("Do you want to perform other opration? (yes/no): ");
                String response2 = sc2.nextLine();
                if(response2.equalsIgnoreCase("no"))
                {
                    continueOperations = false;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Something went wrong. Please try again");
        }
        
        System.out.println("Thank you " + name); 
        System.out.println("Have a nice day..."); 
        
        sc.close();
    }
}