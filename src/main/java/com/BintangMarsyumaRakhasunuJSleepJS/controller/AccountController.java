package com.BintangMarsyumaRakhasunuJSleepJS.controller;

import com.BintangMarsyumaRakhasunuJSleepJS.Account;
import com.BintangMarsyumaRakhasunuJSleepJS.Algorithm;
import com.BintangMarsyumaRakhasunuJSleepJS.Payment;
import com.BintangMarsyumaRakhasunuJSleepJS.Renter;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.*;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

// TODO sesuaikan dengan package Anda: package com.netlabJSleepGS.controller;


// TODO sesuaikan dengan package Anda: import com.netlabJSleepGS.Account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a controller for an account.
 * It provides methods for logging in, registering a new account,
 * and registering a new renter associated with an account.
 *
 * @author Bintang MR
 *
 * @implements BasicGetController<Account>
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    /** A regular expression for a valid password. */
    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    /** A regular expression for a valid email. */
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";

    @JsonAutowired(value = Account.class, filepath = "C:\\Main\\Documents\\Kuliah\\Teknik Komputer\\SEMESTER 3\\Pemrograman Berbasis Objek\\Project\\JSleep\\src\\main\\java\\com\\json\\account.json")
    public static JsonTable<Account> accountTable;

    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD) ;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);

    /**
     * Returns the table of accounts.
     *
     * @return the table of accounts
     */
    public JsonTable<Account> getJsonTable() {
        return AccountController.accountTable;
    }

    /**
     * Logs in an account with the specified email address and password.
     *
     * @param email the email address of the account
     * @param password the password of the account
     *
     * @return the account if the login is successful, or null if the login fails
     */
    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        final String finalPassword = generatedPassword;
        Account temp = Algorithm.<Account>find(accountTable,pred -> email.equals(pred.email) && finalPassword.equals(pred.password));
        return temp;
    }
    /**
     * Registers a new account with the specified name, email, and password.
     * The email and password must match the regular expressions for a valid email address
     * and password, respectively. The name cannot be blank.
     *
     * @param name the name of the new account
     * @param email the email address of the new account
     * @param password the password of the new account
     *
     * @return the newly registered account if the registration is successful, or null if the registration fails
     */
    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        String generatedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        final String finalPassword = generatedPassword;
        Matcher matcheremail = REGEX_PATTERN_EMAIL.matcher(email);
        boolean emailstatus = matcheremail.find();
        Matcher matcherpassword = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean passwordstatus = matcherpassword.find();
        if(passwordstatus && emailstatus && !name.isBlank()){
            accountTable.add(new Account(name,email,finalPassword));
            return new Account(name, email, finalPassword);
        }
        else{
            return null;
        }

    }
    /**
     * Registers a new renter for the account with the specified ID.
     * The renter must not already be registered for the account.
     *
     * @param id the ID of the account for which the renter is being registered
     * @param username the username of the new renter
     * @param address the address of the new renter
     * @param phoneNumber the phone number of the new renter
     *
     * @return the newly registered renter if the registration is successful, or null if the registration fails
     */
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address,
                          @RequestParam String phoneNumber ){

        Account temp = Algorithm.<Account>find(getJsonTable(),pred -> pred.id == id);
        if(temp.renter == null){
            temp.renter = new Renter(username, address, phoneNumber);
            return temp.renter;
        }
        else{
            return null;
        }
    }
    /**
     * Adds the specified amount to the balance of the account with the specified ID.
     *
     * @param id the ID of the account
     * @param balance the amount to add to the account balance
     *
     * @return true if the balance was successfully added, or false if the account with the specified ID was not found
     */
    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance ){
        Account account = Algorithm.<Account>find(getJsonTable(), acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }



}