package BintangMarsyumaRakhasunuuJSleepJS;


/**
 * Write a description of class Price here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */
public class Price {
    public double rebate;
    public double price ;
    public int discount;

    public Price(double price){
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    private double getDiscountedPrice(){
        if((double)discount > 100.0){
            discount = (int) 100.0;
            return 0;
        }
        return price - (price * discount / 100);
    }
    private double getRebatedPrice(){
        if (rebate > price){
            rebate = price;
            return rebate;
        }
        return price- (price - rebate);
    }
}