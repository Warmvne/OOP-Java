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
