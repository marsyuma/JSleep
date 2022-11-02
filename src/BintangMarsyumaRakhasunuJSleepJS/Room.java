package BintangMarsyumaRakhasunuJSleepJS;


/**
 * Write a description of class Price here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version PT Mod 4
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Room extends Serializable
{
    public ArrayList<Date> booked;
    public int size;
    public int accountId;
    public String name;
    public String address;
    public Facility facility;
    public BedType bedType;
    public City city;
    public Price price;

    public Room (int acccountId, String name, int size, Price price, Facility facility, City city, String address){
        this.accountId = acccountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = bedType.KING;
        this.booked = new ArrayList<Date>();
    }

    public String toString(){
        return "Id : " + this.id + "\nNama : " + this.name +
                "\nSize :" + this.size +
                "\nTipe Kasur : " + this.bedType +
                "\nKota : " + this.city +
                "\nFasilitas : " + this.facility +
                "\nHarga : " + this.price.price + " Rupiah" +
                "\nAlamat : " + this.address + "\n";
    }

    public Object write() {
        return null;
    }

    public boolean read(String string) {
        return false;
    }
}