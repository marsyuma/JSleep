package com.BintangMarsyumaRakhasunuJSleepJS;


/**
 * Class for processing Room processes.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version PT Mod 4
 */

import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;

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
    public ArrayList<Facility> facility = new ArrayList<>();
    public BedType bedType;
    public City city;
    public Price price;

    /**
     * Constructs a new Room object with the given parameters.
     * @param acccountId the ID of the account that owns this room
     * @param name the name of the room
     * @param size the size of the room in square meters
     * @param price the price of the room per night
     * @param facility the list of facilities available in the room
     * @param city the city where the room is located
     * @param address the address of the room
     * @param bedType the type of bed in the room
     */
    public Room (int acccountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType){
        this.accountId = acccountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility.addAll(facility);
        this.city = city;
        this.address = address;
        this.bedType = bedType;
        this.booked = new ArrayList<Date>();
    }

    /**
     * Returns a string representation of this Room object.
     * @return a string representation of this Room object
     */
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