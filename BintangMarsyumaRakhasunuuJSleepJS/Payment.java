package BintangMarsyumaRakhasunuuJSleepJS;


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

    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to){
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance().getTime();
        this.to = Calendar.getInstance().getTime();
    }
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to){
        super(id, buyer, renter);
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
            for (Date date = from; date.before(to); ) {
                room.booked.add(date);
                Calendar temp = Calendar.getInstance();
                temp.setTime(date);
                temp.add(Calendar.DATE, 1);
                date = temp.getTime();
            }
            return true;
        }
        return false;
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

