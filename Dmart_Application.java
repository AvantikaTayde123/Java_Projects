import java.util.Scanner;
public class Dmart_Application {
    public static void main(String[] args){
         double purchase_amt;
         double discount;
         Double total_bill;
         //double ab;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter The purchase Amount");
        purchase_amt = s.nextDouble();

         if(purchase_amt>=3000 & purchase_amt<5000){
            System.out.println("you get a flat rs.500 discount");
            double ab=purchase_amt-500;
            System.out.println("Total bill amount="+ab);
         }

         else if(purchase_amt>=5000 & purchase_amt<10000){
            System.out.println("you get a 30% discount");
             discount=(30/purchase_amt)*100;
            double ab=purchase_amt-discount;
            System.out.println("Total Bill amount="+ab);
         }
        else if(purchase_amt>=10000 & purchase_amt<15000){
            System.out.println("you get a Free Gift");
                System.out.println("you get a Free Mixer");
            }
         else if(purchase_amt>=15000){
                System.out.println("you get a Free Suitcase");
            }
         else{
             System.out.println("Thankyou for Shopping");
         }

    
    }
}
