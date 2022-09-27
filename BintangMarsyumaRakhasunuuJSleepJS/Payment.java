package BintangMarsyumaRakhasunuuJSleepJS;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice{
    public String to;
    public String from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to){
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to){
        super(id, buyer.id, renter.id, time);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    public String print(){
        return ("to: " + this.to + " from: " + this.from + " roomId: " +this.roomId);
    }
    public int getRoomId(){
        return roomId;
    }
    
}