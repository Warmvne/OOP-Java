////////////////////////////// QUESTION 1 ///////////////////////////////////////

import java.util.Random;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    int[]lottery=new int[5];
	    int[]user=new int[5];
	    Scanner keyboard=new Scanner(System.in);
	    System.out.println("Choose your numbers:");
	    for(int i=0;i<user.length;i++){
	        user[i]=keyboard.nextInt();
	    }
	    
	    Lottery test=new Lottery(lottery,user);
	    test.IsMatching();
	    test.showArray();
		
	}
}


class Lottery{
    private int[] lotteryNumbers = new int[5];
    private int[] numbersPicked = new int [5];
    
    public Lottery(int[]tab,int[]tabl){
        for(int i=0;i<lotteryNumbers.length;i++){
            Random rand=new Random();
            tab[i]=rand.nextInt(9);
        }
        lotteryNumbers=tab;
        numbersPicked=tabl;
    }
    
    public void IsMatching(){
        int compt=0;
        for(int i=0;i<lotteryNumbers.length;i++){
            if(lotteryNumbers[i]==numbersPicked[i]){
                compt++;
            }
            else{}
        }
        if(compt==5){
            System.out.println("Congratulations, you're the winner !!");
        }
        else{
            System.out.println("Not you're lucky day...Try again !");
        }
    }
    
    public void showArray(){
        System.out.println("lottery array:");
        for(int i=0;i<lotteryNumbers.length;i++){
            System.out.print(lotteryNumbers[i]+"\t");
        }
        System.out.println("\n\nuser array:");
        for(int i=0;i<lotteryNumbers.length;i++){
            System.out.print(numbersPicked[i]+"\t");
        }
    }
}
