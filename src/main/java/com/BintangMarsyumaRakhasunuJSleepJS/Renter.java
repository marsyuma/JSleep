package com.BintangMarsyumaRakhasunuJSleepJS;


import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;

/**
 * Class for processing renter.
 *
 * @author Bintang MR
 * @version Modul 5
 */
public class Renter extends Serializable {
    public String phoneNumber;
    public String address = "";
    public String username = "";
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public static final String REGEX_PHONE_NUMBER = "^[0-9]{9,12}$";

    /**
     * Creates a new instance of the {@link Renter} class with the specified username, phone number, and address.
     *
     * @param username The username of the renter.
     * @param phoneNumber The phone number of the renter.
     * @param address The address of the renter.
     */
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
