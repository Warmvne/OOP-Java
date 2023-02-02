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
public class CreateLoans extends Loan{
    final int length_array =5;
    ArrayList<Loan> NewLoans= new ArrayList<>();
    Scanner input = new Scanner(System.in);
    int LoanNumber;
    String nameCustomer;
    double AmountLoan;
    double interest_rate;
    double termLoan;
    String type;
    System.out.println("Enter the current prime interest rate (in %) :");
    interest_rate = input.nextDouble() / 100;
    
    
    
}

////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                        //
//                      A FINIR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!          //
//                                                                                        //
////////////////////////////////////////////////////////////////////////////////////////////
