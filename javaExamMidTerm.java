////////////////////////////////////////// QUESTION 1 //////////////////////////////////////////

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
	    ArrayList<Employee> employee = new ArrayList<>();
	    String firstname;
	    String lastname;
	    int numSS;
	    int hours_worked;
	    double hours_wage;
	    double commission_rate;
	    double gross_sale;
	    int choice;
	    Scanner input=new Scanner(System.in);
	    
	    for (int i=0;i<4;i++){
	           System.out.println("First Name ?: ");
	           firstname=input.next();
	           System.out.println("Last Name ?: ");
	           lastname=input.next();
	           System.out.println("Security social number ?: ");
	           numSS=input.nextInt();
	           System.out.println("What Kind of employee do you want to register ? (enter 1/2/3/4)");
	           choice=input.nextInt();
	           if(choice==1){
	               employee.add(new Salaried_Employee(firstname,lastname,numSS));
	           }
	           else if(choice==2){
	               System.out.println("Hours worked ?: ");
	               hours_worked=input.nextInt();
	               System.out.println("Hours wage ?: ");
	               hours_wage=input.nextDouble();
	               employee.add(new Hourly_Employee(firstname,lastname,numSS,hours_worked,hours_wage));
	           }
	           else if(choice==3){
	               System.out.println("Commission Rate ?: ");
	               commission_rate=input.nextDouble();
	               System.out.println("Gross Sale ?: ");
	               gross_sale=input.nextDouble();
	               employee.add(new Commission_Employee(firstname,lastname,numSS,commission_rate,gross_sale));
	           }
	           else{
	               System.out.println("Commission Rate ?: ");
	               commission_rate=input.nextDouble();
	               System.out.println("Gross Sale ?: ");
	               gross_sale=input.nextDouble();
	               employee.add(new BasePlus_Commission_Employee(firstname,lastname,numSS,commission_rate,gross_sale));
	           }
	    }
	    
	    for(int i=0;i<4;i++){
	        System.out.println(employee.get(i));
	    }
	}
}

abstract class Employee{
    //variables
    private String firstname;
    private String lastname;
    private int social_security_number;
    
    //constructor
    public Employee(String fName, String lname,int numSS){
        firstname=fName;
        lastname=lname;
        social_security_number=numSS;
    }
    
    //set methods
    public void setFirstName(String fName){
        firstname=fName;
    }
    public void setLastName(String lname){
        firstname=lname;
    }
    public void set_SS_number(int num){
        social_security_number=num;
    }
    
    //get methods
    public String getFirstName(){
        return firstname;
    }
    public String getLastName(){
        return lastname;
    }
    public int get_SS_num(){
        return social_security_number;
    }
}


class Salaried_Employee extends Employee{
    private double basesalary;
    
    public Salaried_Employee(String fName,String lname,int numSS){
        super(fName,lname,numSS);
        setSalary();
    }
    
    public void setSalary(){
        basesalary=1300;
    }
    public double getSalary(){
        return basesalary;
    }
}




class Hourly_Employee extends Employee{
    private int hours_worked;
    private double hours_wage;
    private double TotalWage;
    
    public Hourly_Employee(String fName,String lname,int numSS,int hours_worked,double hours_wage){
        super(fName,lname,numSS);
        this.hours_worked=hours_worked;
        this.hours_wage=hours_wage;
        setWage();
    }
    
    public void setWage(){
        if(hours_worked<40){
            TotalWage=hours_worked*hours_wage;
        }
        else{
            TotalWage=hours_wage*hours_worked + (1.5*hours_wage*(hours_worked-40));
        }
    }
    
    public double getWage(){
        return TotalWage;
    }
}



class Commission_Employee extends Employee{
    private double commission_rate;
    private double gross_sale;
    private double commissioner_salary;
    
    public Commission_Employee(String fName,String lname,int numSS,double commission_rate,double gross_sale){
        super(fName,lname,numSS);
        setSalaryCommissioner();
    }
    
    public void setSalaryCommissioner(){
        commissioner_salary=gross_sale*commission_rate;
    }
    
    public double getSalaryCommissioner(){
        return commissioner_salary;
    }
}



class BasePlus_Commission_Employee extends Commission_Employee{
    private double TotalSalaryCommissioner;
    
    public BasePlus_Commission_Employee(String fName,String lname,int numSS,double commission_rate,double gross_sale){
        super(fName,lname,numSS,commission_rate,gross_sale);
        setTotalSalary();
    }
    
    public void setTotalSalary(){
        TotalSalaryCommissioner=super.getSalaryCommissioner() + super.super.getSalary();
    }
}


////////////////////////////////////////// QUESTION 2 //////////////////////////////////////////

