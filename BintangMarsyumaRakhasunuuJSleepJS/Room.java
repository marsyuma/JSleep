package BintangMarsyumaRakhasunuuJSleepJS;


/**
 * Write a description of class Price here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */
public class Room {
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public Room (String name, int size, Price price, Facility facility){
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }
}