package com.BintangMarsyumaRakhasunuJSleepJS;


import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;

/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable {
    public String phoneNumber;
    public String address = "";
    public String username = "";
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public static final String REGEX_PHONE_NUMBER = "^[0-9]{9,12}$";

    public Renter(String username, String phoneNumber, String address){
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public boolean validate(){
        if (this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE_NUMBER)){
            return true;
        }
        return false;
    }

}
