///////////////////////////////// Question 1 //////////////////////////////////////

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    HolidayCabinRental cabin;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of the room you want:");
        cabin = new HolidayCabinRental(input.nextInt());
        System.out.println("the weekly rental rate will be " + cabin.getRentWeek());
	}
}

class CabinRental{
    private int cabinID;
    private double week_rent;
    
    public CabinRental(int num){
        cabinID=num;
        if(cabinID==1||cabinID==2||cabinID==3){
            week_rent=950;
        }
        else{
            week_rent=1100;
        }
    }
    
    public int getCabinNUM(){
        return cabinID;
    }
    
    public double getRentWeek(){
        return week_rent;
    }
    
    public void setRentWeek(double rent){
        week_rent=rent;
    }
}

class HolidayCabinRental extends CabinRental{
    
    
    public HolidayCabinRental(int roomNumber){
        super(roomNumber);
        //CabinRental room=new CabinRental(roomNumber);
        double rent=getRentWeek();
        setRentWeek(rent+150);
        
    }
}


///////////////////////////////// Question 2 //////////////////////////////////////

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    
		Scanner input = new Scanner(System.in);
        String courseDep;
        int number, credits;
        System.out.println("Enter the course department:");
        courseDep = input.next();
        System.out.println("Enter course number:");
        number = input.nextInt();
        System.out.println("Enter the number of credits for the course:");
        credits = input.nextInt();
        if(courseDep.equalsIgnoreCase("BIO") || courseDep.equalsIgnoreCase("CHM") || courseDep.equalsIgnoreCase("CIS") || courseDep.equalsIgnoreCase("PHY"))
        {
            LabCourse course = new LabCourse(courseDep, number, credits);
            course.display();
        }
        else 
        {
            CollegeCourse course = new CollegeCourse(courseDep, number, credits);
            course.displayCourseData();
        }
	}
}

class CollegeCourse{
    
    private String department;
    private int CourseNumber;
    private int credit;
    private double courseFee;
    
    public CollegeCourse(String department,int CourseNumber,int credit){
        this.department=department;
        this.CourseNumber=CourseNumber;
        this.credit=credit;
        courseFee=credit*120;
    }
    
    public String getDepartment(){
        return department;
    }
    
    public int getCourseNumber(){
        return CourseNumber;
    }
    
    public int getCredit(){
        return credit;
    }
    
    public double getCourseFee(){
        return courseFee;
    }
    
    public void setCourseFee(double fee){
        courseFee=fee;
    }
    
    public void displayCourseData(){
        System.out.println(department + " " + CourseNumber + " :");
        System.out.println("Credits : " + credit);
        System.out.println("Fee : $" + courseFee);
    }
}

class LabCourse extends CollegeCourse{
    
    public LabCourse(String department,int CourseNumber,int credit){
        super(department,CourseNumber,credit);
        double fee=this.getCourseFee();
        this.setCourseFee(fee+50);
    }
    
    public void display(){
        System.out.println("Lab course " + this.getDepartment() + " " + this.getCourseNumber() + " :");
        System.out.println("Credits : " + this.getCredit());
        System.out.println("Fee : $" + this.getCourseFee());
    }
}
///////////////////////////////// Question 3 //////////////////////////////////////

public class Main
{
	public static void main(String[] args) {
	    PreferredCustomer FavCustomer= new PreferredCustomer();
	    FavCustomer.setName("Marwane");
	    FavCustomer.setAddress("10 Downing Street, London");
	    FavCustomer.setPhoneNumber("unknown");
	    FavCustomer.setCustomerNumber(95);
	    FavCustomer.setMailList(false);
	    FavCustomer.setAmountPurchase(1010);
	    
	    System.out.println("Customer's number: "+ FavCustomer.getCustomerNumber());
	    System.out.println("Customer's name: "+ FavCustomer.getName());
	    System.out.println("Customer's address: "+ FavCustomer.getAddress());
	    System.out.println("Customer's phone number: "+ FavCustomer.getPhoneNumber());
	    if(FavCustomer.IsMailList()) System.out.println(FavCustomer.getName()+" is subscribed to the newsletter.");
	    else System.out.println(FavCustomer.getName()+" is not subscribed to the newsletter.");
	    System.out.println("Amount purchase: "+FavCustomer.getAmountPurchase());
	    System.out.println("Discount on your next purchase: "+ FavCustomer.getDiscount(FavCustomer.getAmountPurchase())*100+"%");
	}
}

class Person{
    private String name;
    private String address;
    private String phone_number;
    
    public Person(){
        name="";
        address="";
        phone_number="";
    }
    public Person(String name,String address,String phone_number){
        this.name=name;
        this.address=address;
        this.phone_number=phone_number;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String nom){
        name=nom;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String adresse){
        address=adresse;
    }
    
    public String getPhoneNumber(){
        return phone_number;
    }
    
    public void setPhoneNumber(String phone){
        phone_number=phone;
    }
}

class Customer extends Person{
    private int CustomerNumber;
    private boolean email_list;
    
    public Customer(){
        super();
        CustomerNumber=0;
        email_list=false;
    }
    
    public Customer(String name, String address, String phone_number, int CustomerNumber, boolean email_list){
        super(name,address,phone_number);
        this.CustomerNumber=CustomerNumber;
        this.email_list=email_list;
    }
    
    public int getCustomerNumber(){
        return CustomerNumber;
    }
    
    public void setCustomerNumber(int num){
        CustomerNumber=num;
    }
    
    public boolean IsMailList(){
        return email_list;
    }
    
    public void setMailList(boolean mail){
        email_list=mail;
    }
}

class PreferredCustomer extends Customer{
    private double amount_purchase;
    private double discount;
    
    public PreferredCustomer(){
        super();
        amount_purchase=0;
        discount=0;
    }
    
    public PreferredCustomer(String name, String address, String phone_number, int CustomerNumber, boolean email_list,double amount_purchase){
        super(name,address,phone_number,CustomerNumber,email_list);
        this.amount_purchase=amount_purchase;
        discount=getDiscount(amount_purchase);
    }
    
    public double getAmountPurchase(){
        return amount_purchase;
    }
    
    public void setAmountPurchase(double amount){
        amount_purchase=amount;
    }
    
    public double getDiscount(double amount_purchase){
        if(amount_purchase>2000) return 0.1;
        else if(amount_purchase>1500) return 0.07;
        else if(amount_purchase>1000) return 0.06;
        else if(amount_purchase>500) return 0.05;
        else return 0;
    }
    
    public double getDiscount(){
        return discount;
    }
}
