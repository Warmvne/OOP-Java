/**************************************************************************************************************************************************************************************************************************************


Write an application that prompts the user to enter a number to use as an array size, and then attempt to declare an array using the entered size. If the array is created successfully, display an appropriate message. 
Java generates a NegativeArraySizeException if you attempt to create an array with a negative size
Use a catch block that executes if the array size is negative, displaying a message that indicates the array was not created. Save the file as NegativeArray.java. 

**************************************************************************************************************************************************************************************************************************************/

package trainingexam;
import java.util.Scanner;
/**
 *
 * @author 932254331
 */
public class TrainingExam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size_array;
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the size of the array :");
        size_array=input.nextInt();
        try{
         int[]tab= new int[size_array];
         System.out.println("The array has been successfuly created");
        }
        catch(NegativeArraySizeException mistake){
            System.out.println("The size chosen is not allowed");
        }
        
    }
    
}
