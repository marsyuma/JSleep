package BintangMarsyumaRakhasunuJSleepJS;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable{
    public int phoneNumber = 0;
    public String address = "";
    public String username = "";
    public Renter(String username){
        this.username = username;
    }

    public Renter(String username, String address){
        this.username = username;
        this.address = address;
    }

    public Renter(String username, int phoneNumber){
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public Renter(String username, int phoneNumber, String address){
        this.username = username;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}