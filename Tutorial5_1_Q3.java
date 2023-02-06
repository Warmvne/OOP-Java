////////////////////////////////////// FICHIER STORY //////////////////////////////////////////////

package tuto5_1_q3;

/**
 *
 * @author 932254331
 */
public abstract class Story {
    protected String story_title;
    protected String name_author;
    protected int number_pages;
    protected String message;
    protected final int MIN_PAGES_NOVEL = 100;
    protected final int MAX_PAGES_SHORT_STORY=50;
    protected final int MIN_PAGES_NOVELLA=50;
    protected final  int MAX_PAGES_NOVELLA=100;
    
    public Story(String title,String name,int pages,String message){
        story_title=title;
        name_author=name;
        number_pages=pages;
        this.message=message;
    }
    
    public void setTitle(String title){
        story_title=title;
    }
    public String getTitle(){
        return story_title;
    }
    
    public void setName(String name){
        name_author=name;
    }
    public String getName(){
        return name_author;
    }
    
    public abstract void setNumberPages(int page);
    public int getNumberPages(){
        return number_pages;
    }
    
    public void setMessage(String script){
        message=script;
    }
    public String getMessage(){
        return message;
    }
    
    public void Display(){
        System.out.println("Title: "+ story_title);
        System.out.println("Author: "+ name_author);
        System.out.println("Number of pages: "+ number_pages);
        System.out.println("Message: "+ message);
    }
    
    
    
    
}

////////////////////////////////////// FICHIER NOVEL //////////////////////////////////////////////

package tuto5_1_q3;
import java.util.Scanner;
/**
 *
 * @author 932254331
 */
public class Novel extends Story {
    private int number;
    Scanner input = new Scanner (System.in);
    
    public Novel(String title,String name,int pages,String message){
        super(title,name,pages,message);
        System.out.println("Enter the numbers of pages: ");
        number=input.nextInt();
        setNumberPages(number);
    }
    
    public void setNumberPages(int page){
        this.number_pages=page;
        if(page<this.MIN_PAGES_NOVEL){
            this.message="There are not enough pages for a novel";
        }
        else{
            this.message="the format is good for a novel";
        }
    }
}


////////////////////////////////////// FICHIER NOVELLA //////////////////////////////////////////////

package tuto5_1_q3;

import java.util.Scanner;

/**
 *
 * @author 932254331
 */
public class Novella extends Story {
        private int number;
    Scanner input = new Scanner (System.in);
    
    public Novella(String title,String name,int pages,String message){
        super(title,name,pages,message);
        System.out.println("Enter the numbers of pages: ");
        number=input.nextInt();
        setNumberPages(number);
    }
    
    public void setNumberPages(int page){
        this.number_pages=page;
        if(page<this.MAX_PAGES_NOVELLA){
            if(page>this.MIN_PAGES_NOVELLA){
                this.message="the format is good for a novella";
            }
            else this.message="there are not enough pages for a novella";
            
        }
        else{
            this.message="there are too many pages for a novella";
        }
    }
}


////////////////////////////////////// FICHIER SHORT STORY //////////////////////////////////////////////

package tuto5_1_q3;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 932254331
 */
public class ShortStory extends Story {
        private int number;
        Scanner input = new Scanner (System.in);
    
    public ShortStory(String title,String name,int pages,String message){
        super(title,name,pages,message);
        System.out.println("Enter the numbers of pages: ");
        number=input.nextInt();
        setNumberPages(number);
    }
    
    public void setNumberPages(int page){
        this.number_pages=page;
        if(page>this.MAX_PAGES_SHORT_STORY){
            this.message="There are too many pages for a short story";
        }
        else{
            this.message="the format is good for a short story";
        }
    }
}


////////////////////////////////////// FICHIER STORY DEMO //////////////////////////////////////////////

package tuto5_1_q3;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author 932254331
 */
public class StoryDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String title;
        String name;
        int number=0;
        String message="";
        String choice;
        ArrayList<Story> demo =new ArrayList<>();

        for(int i=0;i<6;i++){
            System.out.println("Enter the type of story: (Novel=N/Novella=Nv/ShortStory=S");
            choice=input.next();
            if(choice.equalsIgnoreCase("N")){
                System.out.println("enter a title: ");
                title=input.next();
                System.out.println("enter the author'name: ");
                name=input.next();
                Story s1 = new Novel(title,name,number,message);
                demo.add(s1);
            }
            else if (choice.equalsIgnoreCase("Nv")){
                System.out.println("enter a title: ");
                title=input.next();
                System.out.println("enter the author'name: ");
                name=input.next();
                Story s2 = new Novella(title,name,number,message);
                demo.add(s2);
            }
            else{
                System.out.println("enter a title: ");
                title=input.next();
                System.out.println("enter the author'name: ");
                name=input.next();
                Story s3 = new ShortStory(title,name,number,message);
                demo.add(s3);
            }
        }

        for(int i=0;i<6;i++){
            demo.get(i).Display();
            System.out.println("\n");
        }
    }
}

