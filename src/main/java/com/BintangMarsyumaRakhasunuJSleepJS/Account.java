package com.BintangMarsyumaRakhasunuJSleepJS;

import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.*;
import com.BintangMarsyumaRakhasunuJSleepJS.controller.*;
import com.BintangMarsyumaRakhasunuJSleepJS.*;

/**
 * The `Account` class represents an account with a balance, a renter, a name,
 * an email, and a password.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 4
 */
public class Account extends Serializable
{
    /**
     * The balance of the account.
     */
    public double balance;

    /**
     * The renter associated with the account.
     */
    public Renter renter;

    /**
     * The name of the account.
     */
    public String name;

    /**
     * The email of the account.
     */
    public String email;

    /**
     * The password of the account.
     */
    public String password;

    /**
     * The regular expression for a valid email.
     */
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";

    /**
     * The regular expression for a valid password.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * Constructs a new `Account` with the given name, email, and password.
     * The balance is initialized to 0.
     *
     * @param name the name of the account
     * @param email the email of the account
     * @param password the password of the account
     */
    public Account(String name,String email,String password){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    /**
     * Returns a string representation of the account.
     *
     * @return a string representation of the account
     */
    public String toString(){
        return "Account\nId: " + super.id + "\nName: " + name + "\nEmail: " + email + "\nPassword: " + password;
    }

    /**
     * Returns `true` if the email and password of the account match the
     * regular expressions for a valid email and password, respectively.
     *
     * @return `true` if the email and password of the account are valid,
     *         `false` otherwise
     */
    public boolean validate(){
        return this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD);
    }
}