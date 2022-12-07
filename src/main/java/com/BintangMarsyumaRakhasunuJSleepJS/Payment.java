package com.BintangMarsyumaRakhasunuJSleepJS;


/**
 * Class for processing payment
 *
 * @author Bintang MR
 * @version TP 6 (KJ lord JS)
 */

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice {


    private int roomId;
    public Date from;
    public Date to;


    /**
     * Constructs a `Payment` object with the given buyer ID, renter ID, room ID, start date, and end date.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     * @param roomId the ID of the room being booked
     * @param from the start date of the booking
     * @param to the end date of the booking
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to) {
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a `Payment` object with the given buyer account, renter, room ID, start date, and end date.
     *
     * @param buyer the buyer account
     * @param renter the renter
     * @param roomId the ID of the room being booked
     * @param from the start date of the booking
     * @param to the end date of the booking
     */
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to) {
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the ID of the room being booked.
     *
     * @return the room ID
     */
    public int getRoomId() {
        return roomId;
    }

    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }

    public static boolean availability(Date from,Date to,Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

    /*public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("'Formatted Date' = dd MMMM yyyy");

    }*/

    @Override
    public String print(){
        return "Payment{" +
                "roomId=" + roomId +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }

}

