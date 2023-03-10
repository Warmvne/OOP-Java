////////////////////////////////////// FICHIER BOOK ///////////////////////////////////////////////

package tuto5_1_q1;

/**
 *
 * @author 932254331
 */
public abstract class Book {
    
    protected String book_title;
    protected double book_price;
    
    public Book (String title, double price){
        book_title=title;
        book_price=price;   
    }
    
    public String getTitle(){
     return book_title;
    }
    
    public double getPrice(){
        return book_price;
    }
    
    public abstract void setPrice();
    
    public void Display(){
        System.out.println("Title: "+ book_title);
        System.out.println("Price: "+ book_price);
    }
}

////////////////////////////////////// FICHIER FICTION ////////////////////////////////////////////////////

package tuto5_1_q1;

/**
 *
 * @author 932254331
 */
public class Fiction extends Book {
    
     public Fiction(String title, double price){
        super(title,price);
        setPrice();
    }
     
    public void setPrice(){
        this.book_price=24.99;
    }
}

/////////////////////////////////// FICHIER NON FICTION //////////////////////////////////////////////

package tuto5_1_q1;

/**
 *
 * @author 932254331
 */
public class NonFiction extends Book {
    
    public NonFiction(String title, double price){
        super(title,price);
        setPrice();
    }
    
    public void setPrice(){
        this.book_price=37.99;
    }
}

/////////////////////////// FICHIER USE BOOK ///////////////////////////////////////////////////////

package tuto5_1_q1;

/**
 *
 * @author 932254331
 */
public class UseBook {
    public static void main(String[] args){
        Book book1 = new Fiction("Harry Potter",0);
        Book book2 = new NonFiction("Siddharta",0);
        
        book1.Display();
        book2.Display();
    }
}

////////////////////////////////// FICHIER BOOK ARRAY ///////////////////////////////////////////////

package tuto5_1_q1;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author 932254331
 */
public class BookArray {
    public static void main(String[] args) {
        String choice;
        Scanner input= new Scanner (System.in);
        ArrayList<Book> livre =new ArrayList<>();
        for(int i=0;i<10;i++){
            System.out.println("Do you want a Fiction book or a Non-Fiction ? (type N or NF)");
            choice=input.next();
            if(choice.equalsIgnoreCase("N")){
                Book book1 = new Fiction("Harry Potter i",0);
                livre.add(book1);
            }
            else{
                Book book2 = new NonFiction("Steve Jobs Biography",0);
                livre.add(book2);
            }
        }
        
        for (int i=0;i<10;i++){
            livre.get(i).Display();
        }
        
    }
}
