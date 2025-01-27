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


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/**************************************************************************************************************************************************************************************************************************************


Write a class named TestScores. The class constructor should accept an array of test scores as its argument. 
The class should have a method that returns the average of the test scores. 
If any test score in the array is negative or greater than 100, the class should throw an IllegalArgumentException.
Demonstrate the class in a program. 

***************************************************************************************************************************************************************************************************************************************/


package lecture7;
import java.util.Scanner;
/**
 *
 * @author 932254331
 */
public class Lecture7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[]array=new int[5];
        TestScores test1 = new TestScores(array);
        test1.FillArray();
        System.out.println("Average of this test is "+ test1.AverageGrade());
    }
    
}

class TestScores{
    private final int MAX_GRADE =100;
    private final int MIN_GRADE=0;
    private int[] array= new int[5];
    
   public TestScores(int[]array){
       this.array=array;
   }
   
   public int AverageGrade(){
       int sum=0;
       for(int i=0;i<array.length;i++){
           sum+=array[i];
       }
       int avg=sum/array.length;
       return avg;
   }
   
   public void FillArray(){
       int grade;
       Scanner input = new Scanner(System.in);
       for(int i=0;i<array.length;i++){
           try{
               System.out.println("Input a grade: ");
               grade=input.nextInt();
               if(grade<MIN_GRADE|| grade>MAX_GRADE){
                    throw new IllegalArgumentException("The grade is not between 0 and 100");
               }
               else{
                    array[i]=grade;
               }
           }
           catch(IllegalArgumentException mistake){
               System.out.println(mistake.getMessage());
               System.out.println("The grade has been registered as zero");
               grade=0;
               array[i]=grade;
               
           }
       }
   }
    
}
