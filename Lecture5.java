//////////////////////////////////////// GEOMETRIC FIGURE ////////////////////////////////////

package lecture5;

/**
 *
 * @author 932254331
 */


public abstract class GeometricFigure{
    protected double height;
    protected double width;
    protected String figure_type;
    protected double area;
    
    public GeometricFigure(double h, double w, String type,double area){
        height=h;
        width=w;
        figure_type=type;
        this.area=area;
    }
    
    public abstract double getArea();
    
    public void Display(){
        System.out.println("height: "+ height);
        System.out.println("width: "+ width);
        System.out.println("type: "+ figure_type);
        System.out.println("area: "+ area);
    }
}

////////////////////////////////////////// FICHIER SQUARE /////////////////////////////////////////////

package lecture5;

/**
 *
 * @author 932254331
 */
public class Square extends GeometricFigure{
    
    public Square(double h, double w, String type,double area){
        super(h,w,type,area);
        this.area=getArea();
    }
      
    public double getArea(){
        return height*width;
    }
}

//////////////////////////////////////// FICHIER TRIANGLE ///////////////////////////////////////////

package lecture5;

/**
 *
 * @author 932254331
 */
public class Triangle extends GeometricFigure {
    
    public Triangle(double h, double w, String type,double area){
        super(h,w,type,area);
        this.area=getArea();
    }
    public double getArea(){
        return height*width/2;
    }
}


////////////////////////////////////// FICHIER DEMO /////////////////////////////////////////////////

package lecture5;
import java.util.ArrayList;
/**
 *
 * @author 932254331
 */
public class DemoLecture5 {
    public static void main(String[] args){
        ArrayList<GeometricFigure> figure = new ArrayList<>();
        GeometricFigure trig = new Triangle(2,3,"TrigRectangle",0);
        GeometricFigure Sqr = new Square(2,3,"Rectangle",0);
        
        figure.add(trig);
        figure.add(Sqr);
        
        figure.get(0).Display();
        System.out.println("\n");
        figure.get(1).Display();
        
    }
}
