package com.BintangMarsyumaRakhasunuJSleepJS;


/**
 * Write a description of class Price here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */
/**
 * Write a description of class Price here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */
/**
 * Write a description of class Price here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */
public class Rating {
    private long total;
    private long count;

    public Rating(){
        this.total = 0;
        this.count = 0;
    }
    public void insert(int rating){
        total += rating;
        count++;
    }
    public double getAverage(){
        if(count == 0){
            return 0;
        }
        return total/count;
    }
    public long getCount(){
        return count;
    }
    public long getTotal(){
        return total;
    }

    public String toString(){
        return "Total : " + this.total + "\nCount : " + this.count;
    }
}


