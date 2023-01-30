///////////////////////////////////// Employee exercise //////////////////////////////////////////////

public class Course5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductionWorker employee=new ProductionWorker("Marwane",95,"01/01/2023",1,10.5);
        
        
        employee.Display();
        
    }
    
}

class Employee{
    private String Emp_name;
    private int Emp_num;
    private String Hire_Date;
    
   
    
    public Employee(String Emp_name, int Emp_num, String Hire_Date){
        this.Emp_name=Emp_name;
        this.Emp_num=Emp_num;
        this.Hire_Date=Hire_Date;
        
    }
    
   
    public String getName(){
        return Emp_name;
    }
    
   
    public int getNum(){
        return Emp_num;
    }
    
    
    public String getDate(){
        return Hire_Date;
    }
    
}

class ProductionWorker extends Employee{
    private int shift;
    private double PayRateHourly;
    
    
    
    public ProductionWorker(String name,int num,String date,int shift, double PayRateHourly){
        super(name,num,date);
        this.shift=shift;
        this.PayRateHourly=PayRateHourly;
    }
    
   
    public int getShift(){
        return shift;
    }
    
    
    public double getPayRate(){
        return PayRateHourly;
    }
    
    public void Display(){
        System.out.println("Employee's name: "+ this.getName());
        System.out.println("Employee's num: "+ this.getNum());
        System.out.println("Date hire: "+ this.getDate());
        if(this.getShift()==0){
            System.out.println("The employee works on day");
            System.out.println("Pay per hour: "+ this.getPayRate());
        }
        else{
            System.out.println("The employee works on night");
            System.out.println("Pay per hour: "+ this.getPayRate()*2);
        }
        
    }
}
