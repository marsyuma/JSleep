package com.BintangMarsyumaRakhasunuJSleepJS;



/**
 * A class that represents a rating for an item.
 *
 * @author Bintang MR
 * @version Modul 5
 */
public class Rating {
    private long total;
    private long count;

    /**
     * Constructs a new Rating with total and count set to 0.
     */
    public Rating(){
        this.total = 0;
        this.count = 0;
    }

    /**
     * Inserts a new rating.
     *
     * @param rating The rating to insert.
     */
    public void insert(int rating){
        total += rating;
        count++;
    }

    /**
     * Gets the average rating.
     *
     * @return The average rating, or 0 if there are no ratings.
     */
    public double getAverage(){
        if(count == 0){
            return 0;
        }
        return total/count;
    }

    /**
     * Gets the total number of ratings.
     *
     * @return The total number of ratings.
     */
    public long getCount(){
        return count;
    }

    /**
     * Gets the total sum of all ratings.
     *
     * @return The total sum of all ratings.
     */
    public long getTotal(){
        return total;
    }

    /**
     * Returns a string representation of this Rating.
     *
     * @return A string representation of this Rating.
     */
    public String toString(){
        return "Total : " + this.total + "\nCount : " + this.count;
    }
}