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
