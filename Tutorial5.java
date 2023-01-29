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


///////////////////////////////// Question 3 //////////////////////////////////////
