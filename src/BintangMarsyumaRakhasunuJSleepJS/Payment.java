package BintangMarsyumaRakhasunuJSleepJS;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice{
    SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int buyerId, int renterId, int roomId, Date from, Date to){
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance().getTime();
        this.to = Calendar.getInstance().getTime();
    }
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to){
        super(buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance().getTime();
        this.to = Calendar.getInstance().getTime();
    }

    public static boolean availability(Date from, Date to, Room room){
        if(from.after(to)){
            return false;
        }
        for (Date date : room.booked) {
            if (date.before(to) && date.equals(from)) {
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from, Date to, Room room){
        if(availability(from, to, room)){
            while (from.before(to)){
                room.booked.add(from);
                Calendar temp = Calendar.getInstance();
                temp.setTime(from);
                temp.add(Calendar.DATE, 1);
                from = temp.getTime();
            }
            return true;
        }
        else{
            return false;
        }
    }

    public String getTime(){
        return SDFormat.format(this.time.getTime());
    }

    public String print(){
        return ("to: " + this.to + " from: " + this.from + " roomId: " +this.roomId);
    }
    public int getRoomId(){
        return roomId;
    }

}

