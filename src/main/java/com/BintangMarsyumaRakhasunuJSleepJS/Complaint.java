package com.BintangMarsyumaRakhasunuJSleepJS;

import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;


/**
 * The `Complaint` class represents a complaint with a date and a description.
 *
 * @author Bintang MR
 * @version Modul 5
 */
public class Complaint extends Serializable {
    /**
     * The date of the complaint.
     */
    public String date;

    /**
     * The description of the complaint.
     */
    public String desc;

    /**
     * Constructs a new `Complaint` with the given date and description.
     *
     * @param date the date of the complaint
     * @param desc the description of the complaint
     */
    public Complaint(String date, String desc){
        this.date = date;
        this.desc = desc;
    }

    /**
     * Returns a string representation of the complaint.
     *
     * @return a string representation of the complaint
     */
    public String toString(){
        return ("Tanggal: " + this.date + "\n" +
                "Deskripsi: " + this.desc + "\n");
    }
}