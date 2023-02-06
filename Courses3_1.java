
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



////////////////////////// QUESTION 3 ////////////////////////////////////////////////////

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
		ArrayList<Employee> emp = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		String choice;
		String name;
		int id;
		String dept;
		String pos;
		
		for(int i=0;i<5;i++){
		    System.out.println("Do you know the department and the position of the employee ? (Y=Yes N=No)");
		    choice=input.next();
		    if(choice.equalsIgnoreCase("Y")){
		        System.out.println("Name ?: ");
		        name=input.next();
		        System.out.println("ID ?: ");
		        id=input.nextInt();
		        System.out.println("Department ?: ");
		        dept=input.next();
		        System.out.println("Position ?: ");
		        pos=input.next();
		        Employee emp1 = new Employee (name,id,dept,pos);
		        emp.add(emp1);
		    }
		    else{
		        System.out.println("Name ?: ");
		        name=input.next();
		        System.out.println("ID ?: ");
		        id=input.nextInt();
		        Employee emp2 = new Employee (name,id);
		        emp.add(emp2);
		    }
		}
		
		for(int i=0;i<5;i++){
		    emp.get(i).Display();
		    System.out.println("\n");
		}
	}
}

class Employee{
    private String emp_name;
    private int emp_id;
    private String department;
    private String position;
    
    public Employee(String name,int id,String dept, String pos){
        emp_name=name;
        emp_id=id;
        department=dept;
        position=pos;
    }
    
    public Employee(String name,int id){
        emp_name=name;
        emp_id=id;
        department="";
        position="";
    }
    
    public void setName(String name){
        emp_name=name;
    }
    public String getName(){
        return emp_name;
    }
    
    public void setID(int id){
        emp_id=id;
    }
    public int getID(){
        return emp_id;
    }
    
    public void setDept(String dept){
        department=dept;
    }
    public String getDept(){
        return department;
    }
    
    public void setPosition(String pos){
        position=pos;
    }
    public String getPosition(){
        return position;
    }
    
    
    public void Display(){
        System.out.println("Employee's name: "+ emp_name);
        System.out.println("Employee's ID: "+ emp_id);
        System.out.println("Department: "+ department);
        System.out.println("Position: "+ position);
    }
}


////////////////////////// QUESTION 4 ////////////////////////////////////////////////////

//voir tutorial4 question 1

////////////////////////// QUESTION 5 ////////////////////////////////////////////////////

//voir tutorial4 question 2
