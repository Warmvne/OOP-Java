
///////////////////////////// TUTORIAL 3.1 ////////////////////////////////////////////////


////////////////////////// QUESTION 1 ////////////////////////////////////////////////////
package course3_1;
import java.util.Scanner;
/**
 *
 * @author 932254331
 */
public class Billing {
    
    private static double tax=8.0;
    
    public static double computeBill(double priceBook){
        return priceBook+(priceBook*0.08);
    }
    
    public static double computeBill(double priceBook,int quantity){
        return (priceBook*quantity)+((priceBook*quantity)*0.08);
    }
    
    public static double computeBill(double priceBook, int quantity,double coupon){
        return (priceBook*quantity-coupon)+((priceBook*quantity-coupon)*0.08);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        double total=0;
        double price;
        int quantity;
        double discount;
        do{
            System.out.println("Welcome to our library !");
            System.out.println("Menu:");
            System.out.println("1. One photo book");
            System.out.println("2. Multiple photo books");
            System.out.println("3. Multiple photo books and discount");
            System.out.println("4. Exit");
            Scanner input= new Scanner(System.in);
            System.out.println("");
            System.out.println("Make a choice: ");
            choice=input.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Enter the price of the book: ");
                    price=input.nextDouble();
                    total+=computeBill(price);
                    break;
                case 2:
                    System.out.println("Enter the price of the book: ");
                    price=input.nextDouble();
                    System.out.println("Enter the quantity of books: ");
                    quantity=input.nextInt();
                    total+=computeBill(price,quantity);
                    break;
                case 3:
                    System.out.println("Enter the price of the book: ");
                    price=input.nextDouble();
                    System.out.println("Enter the quantity of books: ");
                    quantity=input.nextInt();
                    System.out.println("Enter the discount: ");
                    discount=input.nextDouble();
                    total+=computeBill(price,quantity,discount);   
                    break;
            }
        
        
        }while(choice!=4);
        
        System.out.println("Your total bill is "+total+" £.");
        
    
    
    
    }
    
}



////////////////////////// QUESTION 2 ////////////////////////////////////////////////////
package course3_1;
import java.util.Scanner;
/**
 *
 * @author 932254331
 */
public class RentalKayak {
    
    public static void main(String[] args) {
        Rental defaultRental = new Rental();
        Rental otherRental = new Rental("A001", 86);
        System.out.println("Default Rental:\n"
                + "Contract number: " + defaultRental.getContractNumber() + "\n"
                + "Number of hours: " + defaultRental.getNumberOfHours() + "\n"
                + "Number of minutes over the hours: " + defaultRental.getNumberOfMinutes() + "\n"
                + "Price: " + defaultRental.getPrice() + "\n");
        System.out.println("Other Rental:\n"
                + "Contract number: " + otherRental.getContractNumber() + "\n"
                + "Number of hours: " + otherRental.getNumberOfHours() + "\n"
                + "Number of minutes over the hours: " + otherRental.getNumberOfMinutes() + "\n"
                + "Price: " + otherRental.getPrice() + "\n");
        System.exit(0);
    }
    
}

class Rental {
    public final static long NUMBER_OF_MINUTES_PER_HOUR = 60;
    public final static double HOURLY_RENTAL_RATE = 40;
    private String contractNumber;
    private long numberOfHours;
    private long numberOfMinutes;
    private double price;

    public Rental(String contractNumber, long numberOfMinutes)
    {
        this.contractNumber = contractNumber;
        numberOfHours = numberOfMinutes / NUMBER_OF_MINUTES_PER_HOUR;
        this.numberOfMinutes = numberOfMinutes % NUMBER_OF_MINUTES_PER_HOUR;
        price = ((double)numberOfHours + (double)this.numberOfMinutes / 60) * HOURLY_RENTAL_RATE;
    }
    
    public Rental()
    {
        this("A000", 100);
    }
    
    public String getContractNumber() {
        return contractNumber;
    }

    public long getNumberOfHours() {
        return numberOfHours;
    }

    public long getNumberOfMinutes() {
        return numberOfMinutes;
    }

    public double getPrice() {
        return price;
    }

}
