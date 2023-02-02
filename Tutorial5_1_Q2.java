/////////////////////////////// FICHIER LOAN /////////////////////////////////////////

package tuto5_1;

import java.util.Scanner;
/**
 *
 * @author 932254331
 */
public abstract class Loan implements LoanConstants{
    private int LoanNumber;
    private String nameCustomer;
    private double AmountLoan;
    private double interest_rate;
    private double termLoan;
    
    public Loan(int num, String name,double amount, double term){
        LoanNumber=num;
        nameCustomer=name;
        if(amount>MaxAmountLoan)AmountLoan=MaxAmountLoan;
        else AmountLoan=amount;
        if(term==long_term)termLoan=long_term;
        else if(term==medium_term)termLoan=medium_term;
        else termLoan=short_term;
        
    }
    
    public String toString(){
        return "Loan Number: "+ LoanNumber
                + "\nName Customer: "+ nameCustomer
                + "\nAmount Loan: "+ AmountLoan
                +"\n Interest: "+ interest_rate
                +"\n Term: "+ termLoan ;
                
    }
}
/////////////////////////////// FICHIER LOANS CONSTANTS /////////////////////////////////////////

package tuto5_1;

/**
 *
 * @author 932254331
 */
public interface LoanConstants {
    int short_term=1;
    int medium_term=3;
    int long_term=5;
    String company="Sanchez Construction Loan Co";
    double MaxAmountLoan= 100000;    
}


/////////////////////////////// FICHIER BUSINESS LOAN /////////////////////////////////////////

package tuto5_1;

/**
 *
 * @author 932254331
 */
public class BusinessLoan extends Loan{
    
    public BusinessLoan(int num, String name,double amount,double interest, double term){
        super(num,name,amount,term);
        interest+=0.01;
    }
}

/////////////////////////////// FICHIER PERSONAL LOAN /////////////////////////////////////////

package tuto5_1;

/**
 *
 * @author 932254331
 */
public class PersonalLoan extends Loan{
    
    public PersonalLoan(int num, String name,double amount,double interest, double term){
        super(num,name,amount,term);
        interest+=0.02;
    }
}
/////////////////////////////// FICHIER CREATE LOANS /////////////////////////////////////////

package tuto5_1;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 932254331
 */
public class CreateLoans extends Loan{ // bug ici jsp pq 
    public static void main(String[] args)
    {
        final int length_array =5;
        ArrayList<Loan> array = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int LoanNumber;
        String nameCustomer;
        double AmountLoan;
        double interest_rate;
        double termLoan;
        String type;
        System.out.println("Enter the current prime interest rate (in %) :");
        interest_rate = input.nextDouble() / 100;
        for(int i=0;i<length_array;i++){
            System.out.println("Enter customer's last name:");
            nameCustomer=input.next();
            System.out.println("Enter loan number:");
            LoanNumber=input.nextInt();
            System.out.println("Enter the amount of the loan:");
            AmountLoan=input.nextDouble();
            System.out.println("Enter loan's term (in years):");
            termLoan=input.nextDouble();
            do
            {
                System.out.println("Enter loan's type:");
                type = input.next();
                if(type.equals("done")) type = "";
                else if(type.equalsIgnoreCase("Business") || type.equalsIgnoreCase("BusinessLoan"))
                {
                    BusinessLoan Client =new BusinessLoan(LoanNumber, nameCustomer, AmountLoan, termLoan);
                    array.add(Client);
                    type = "done";
                }
                else if(type.equalsIgnoreCase("Personal") || type.equalsIgnoreCase("PersonalLoan"))
                {
                    PersonalLoan Perso = new PersonalLoan(LoanNumber, nameCustomer, AmountLoan, termLoan);
                    array.add(Perso);
                    type = "done";
                }
            }while(!(type.equals("done")));
            
            
        }
        for(int i = 0; i < array.size(); i++)
            {
                System.out.println(array.get(i));
            }
    }
    
    
}
