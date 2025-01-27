///////////////////////////////////////////////////////////////// QUESTION 1 ///////////////////////////////////////////////////////////////////////////////

package lecture7;
import java.util.Scanner;
import java.lang.Math.*;

/**
 *
 * @author 932254331
 */

public class NewClass {
    public static void main(String[] args) {
        int number;
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a number: ");
        number=input.nextInt();
        try{
            if(number<0){
                throw new ArithmeticException("We can't calculate the sqaure root of a negative number");
            }
            else{
                System.out.println("The square root of "+number+" is "+ Math.sqrt(number));
            }
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
            System.out.print("Correct the error");
        
        }
    }
}
