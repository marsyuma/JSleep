package com.BintangMarsyumaRakhasunuJSleepJS.controller;


import com.BintangMarsyumaRakhasunuJSleepJS.*;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonAutowired;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * This class represents a controller for a payment.
 * It provides methods create and update a payment,
 *
 * @author Bintang MR
 *
 * @implements BasicGetController<Payment>
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value= Payment.class,filepath = "src/main/java/com/json/payment.json")
    public static JsonTable<Payment> paymentTable;

    /**
     * Returns the table of payments.
     *
     * @return the table of payments
     */
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    /**
     * Accepts the payment with the specified ID.
     * The payment must have a status of WAITING.
     *
     * @param id the ID of the payment to accept
     *
     * @return true if the payment was successfully accepted, or false if the payment was not found or had an invalid status
     */

    @PostMapping("/{id}/accept")
    public boolean accept( @PathVariable int id ){

        Payment payment = Algorithm.<Payment>find(paymentTable,payment1 -> payment1.id == id);
        if(payment == null || payment.status != Invoice.PaymentStatus.WAITING){
            return false;
        }
        else{
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }

    }

    /**
     * Cancels the payment with the specified ID.
     * The payment must have a status of WAITING.
     *
     * @param id the ID of the payment to cancel
     *
     * @return true if the payment was successfully cancelled, or false if the payment was not found or had an invalid status
     */
    @PostMapping("/{id}/cancel")
    public boolean cancel(@PathVariable int id ){
        Payment payment = Algorithm.<Payment>find(paymentTable,payment1 -> payment1.id == id);
        if(payment == null || payment.status != Invoice.PaymentStatus.WAITING){
            return false;
        }
        Account buyer = Algorithm.<Account>find(AccountController.accountTable,account -> account.id == payment.buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable,room1 -> room1.id == payment.getRoomId());
        payment.status = Invoice.PaymentStatus.FAILED;
        buyer.balance += room.price.price;
        return true;

    }
    /**
     * Creates a new payment with the specified details.
     * The payment's status is initially set to WAITING.
     *
     * @param buyerId the ID of the buyer
     * @param renterId the ID of the renter
     * @param roomId the ID of the room
     * @param from the start date of the reservation
     * @param to the end date of the reservation
     *
     * @return the newly created payment
     *
     * @throws ParseException if the dates are in an invalid format
     */
    @PostMapping("/create")
    public Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId);
        System.out.println(Payment.availability(fromDate,toDate,room));
        System.out.println(buyer.balance);
        System.out.println(room.price.price);

        if (buyer == null || room == null || buyer.balance <= room.price.price || !Payment.availability(fromDate, toDate, room)) {
            return null;
        }
        else{
            Payment payment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
            buyer.balance -= room.price.price;
            payment.status = Invoice.PaymentStatus.WAITING;
            if(Payment.makeBooking(fromDate, toDate, room)){
                paymentTable.add(payment);
                return payment;
            }
            else{
                return null;
            }
        }

    }
    /**
     * Submits the payment with the specified ID.
     *
     * @param id the ID of the payment to submit
     *
     * @return true if the payment was successfully submitted, or false if the payment was not found
     */
    @PostMapping("/submit")
    public boolean submit( @RequestParam int id ){
        return false;
    }

    /**
     * Returns a paginated list of payments made by the account with the specified ID.
     *
     * @param id the ID of the account
     * @param page the page number to return
     * @param pageSize the number of items per page
     *
     * @return a paginated list of payments made by the specified account
     */
    @GetMapping("getAll/{id}")
    List<Payment> getAccountPayment(@PathVariable int id, @RequestParam int page, @RequestParam int pageSize){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.buyerId == id);
    }

    /**
     * Return a rating of the renter with the specified ID.
     * @param id
     * @param rating
     * @return
     */
    @PostMapping("/{id}/rating")
    public boolean rating(@PathVariable int id, @RequestParam String rating) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);

        if (payment != null && payment.status == Invoice.PaymentStatus.SUCCESS) {
            System.out.println("rating: "+rating);
            payment.rating = Invoice.RoomRating.valueOf(rating);
            return true;
        }
        return false;
    }@GetMapping("/getOrderForRenter")
    public List<Payment> getOrderForRenter(
            @RequestParam int renterId,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Payment>paginate(getJsonTable(),page,pageSize,pred -> pred.renterId == renterId);
    }

    @GetMapping("/getOrderForBuyer")
    public List<Payment> getOrderForBuyer(
            @RequestParam int buyerId
    ){
        return Algorithm.<Payment>collect(getJsonTable(),pred -> pred.buyerId == buyerId);
    }

}



