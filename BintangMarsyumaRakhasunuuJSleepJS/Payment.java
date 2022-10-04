package BintangMarsyumaRakhasunuuJSleepJS;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment extends Invoice{
    SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
    public Calendar to;
    public Calendar from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);

    }
    public Payment(int id, Account buyer, Renter renter, int roomId){
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    public String getTime(){
        return SDFormat.format(this.time.getTime());
    }
    public String getDuration(){
        return SDFormat.format(this.from.getTime()) + " - " + SDFormat.format(this.to.getTime());
    }
    public String print(){
        return ("to: " + this.to + " from: " + this.from + " roomId: " +this.roomId);
    }
    public int getRoomId(){
        return roomId;
    }

}

