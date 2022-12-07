package com.BintangMarsyumaRakhasunuJSleepJS;


/**
 * The `Invoice` class represents an invoice for a hotel room rental.
 *
 * @author Bintang MR
 * @version PT Modul 9
 */
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

    /**
     * Constructs a new `Invoice` with the given buyer and renter IDs.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     */
    protected Invoice(int buyerId, int renterId){
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Constructs a new `Invoice` with the given buyer and renter accounts.
     *
     * @param buyer the buyer account
     * @param renter the renter account
     */
    public Invoice(Account buyer, Renter renter){
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    /**
     * Returns a string representation of the invoice.
     *
     * @return a string representation of the invoice
     */
    public String print(){
        return ("buyerId: " + this.buyerId + " renterId: " + this.renterId);
    }
}
