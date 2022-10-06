package BintangMarsyumaRakhasunuuJSleepJS;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version Tutam CS3*/
import java.util.Calendar;
import java.util.Date;

public class Invoice extends Serializable{
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
    public Date time;
    public RoomRating rating;
    public PaymentStatus status;

    protected Invoice(int id, int buyerId, int renterId){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance().getTime();
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
    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = Calendar.getInstance().getTime();
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    public String print(){
        return ("buyerId: " + this.buyerId + " renterId: " + this.renterId + " time: " +this.time);
    }
}
