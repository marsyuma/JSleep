package com.BintangMarsyumaRakhasunuJSleepJS;

/**
 * Write a description of enum Type here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 4
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";


    public Account(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public boolean validate(){
        if (this.email.matches(REGEX_EMAIL) && this.password.matches(REGEX_PASSWORD)){
            return true;
        }
        return false;
    }


    public String toString(){
        return "\nNama : " + this.name + "    Email : " + this.email +
                "   Password : " + this.password;
    }
    public Object write() {
        return null;
    }

    public boolean read(String string) {
        return false;
    }
}