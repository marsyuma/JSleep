package com.BintangMarsyumaRakhasunuJSleepJS;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version Tutam CS3*/
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;


public class Invoice extends Serializable {
    public enum RoomRating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    public enum PaymentStatus{
        FAILED,
        WAITING,
        SUCCESS
    }
    public int buyerId;
    public int renterId;
    public RoomRating rating;
    public PaymentStatus status;

    protected Invoice(int buyerId, int renterId){
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    /*protected Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }*/
    public Invoice(Account buyer, Renter renter){
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    public String print(){
        return ("buyerId: " + this.buyerId + " renterId: " + this.renterId);
    }
}
