package com.BintangMarsyumaRakhasunuJSleepJS;


/**
 * Class for processing pricing.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 4
 */
public class Price {
    /*public double rebate;*/
    public double price ;
    public double discount;
    /**
     * Constructs a new `Price` with the given price and no discount.
     *
     * @param price the price of the room
     */
    public Price(double price){
        this.price = price;
        this.discount = 0;
    }

    /**
     * Constructs a new `Price` with the given price and discount.
     *
     * @param price the price of the room
     * @param discount the discount amount
     */
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }

    /**
     * Returns a string representation of this `Price` object.
     *
     * @return a string representation of this `Price` object
     */
    public String toString(){
        return ("Harga : " + this.price + " Diskon : " + this.discount);
    }

    /**
     * Returns the price of the room after discount.
     *
     * @return the price of the room after discount
     */
    private double getDiscountedPrice(){
        if(discount > 100.0){
            discount = (int) 100.0;
            return 0;
        }
        return price - (price * discount / 100);
    }
}