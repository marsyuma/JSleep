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

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;

    public Payment(int buyerId, int renterId,int roomId,Date from,Date to)
    {
        super(buyerId, renterId);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public Payment(Account buyer,Renter renter,int roomId,Date from,Date to){
        super(buyer,renter);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public String print(){
        return "Id :" + this.id + " BuyerId :" + buyerId + " RenterId : " + renterId +
                " RoomId : " + roomId + " From : " + from + " To : " + to;
    }

    public int getRoomId(){
        return roomId;
    }


    public static boolean makeBooking(Date from,Date to,Room room){
        if(availability(from, to, room)){

            while (from.before(to)){
                room.booked.add(from); // Assign ke array
                Calendar tempVar = Calendar.getInstance();
                tempVar.setTime(from);
                tempVar.add(Calendar.DATE, 1); //Increment 1
                from = tempVar.getTime();
            }
            return true;
        }
        else{
            return false;
        }

    }

    //Todo : logic for checking availability and booking
    public static boolean availability(Date from,Date to,Room room){


        if(from.after(to) || from.equals(to)){
            return false;
        }

        for (Date i : room.booked) {
            if (from.equals(i)) {
                return false;
            } else if(from.before(i)){
                if(from.before(i) && to.after(i)){
                    return false;
                }
            }
        }
        return true;
    }




}

