package tutorial5_1_q4;

/**
 *
 * @author 932254331
 */
public class Tutorial5_1_Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       final int NUMBER_OF_POLICIES = 3;
        DiscountPolicy[] policies = new DiscountPolicy[NUMBER_OF_POLICIES];
        
        
        policies[0] = new BulkDiscount(5, 50);
        
       
        policies[1] = new BuyNItemsGetOneFree(3);
        
        
        policies[2] = new CombinedDiscount(policies[0], policies[1]);
        
        for(int i = 0; i < NUMBER_OF_POLICIES; i++)
        {
            System.out.println(policies[i].computeDiscount(500, 10));
        }
    }
    
}

abstract class DiscountPolicy{
    public abstract double computeDiscount(int count,double itemCost);
    
}

class BulkDiscount extends DiscountPolicy{
    protected int minimum;
    protected double percent;
    
    public BulkDiscount(int minimum,double percent){
        this.minimum=minimum;
        this.percent=percent;
    }
    
    public double computeDiscount(int count,double itemCost){
        if(count<minimum)return 0;
        else return count*itemCost*(percent/100);
    }
    
    
}

class BuyNItemsGetOneFree extends DiscountPolicy{
    protected int n;
    
    public BuyNItemsGetOneFree(int n){
        this.n=n;
    }
    
    public double computeDiscount(int count,double itemCost){
        return count/n*itemCost;
    }
}

class CombinedDiscount extends DiscountPolicy{
    protected DiscountPolicy P1;
    protected DiscountPolicy P2;
    
    public CombinedDiscount(DiscountPolicy P1,DiscountPolicy P2){
        this.P1=P1;
        this.P2=P2;
    }
    
    public double computeDiscount(int count,double itemCost){
        if(P1.computeDiscount(count, itemCost)>P2.computeDiscount(count, itemCost))return P1.computeDiscount(count, itemCost);
        else return P2.computeDiscount(count, itemCost);
    }
    
}
