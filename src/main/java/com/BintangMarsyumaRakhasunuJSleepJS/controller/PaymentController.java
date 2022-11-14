package com.BintangMarsyumaRakhasunuJSleepJS.controller;


import com.BintangMarsyumaRakhasunuJSleepJS.*;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonAutowired;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "C:\\Main\\Documents\\Kuliah\\Teknik Komputer\\SEMESTER 3\\Pemrograman Berbasis Objek\\Project\\JSleep\\src\\main\\java\\com\\json\\payment.json")
    private static JsonTable<Payment> paymentTable;

    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    @PostMapping("/{id}/create")
    public Payment createPayment(
            @PathVariable int buyerId,
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
    @PostMapping("/{id}/accept")
    public boolean accept( @RequestParam int id ){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if(payment.status == Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(@RequestParam int id  ){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if(payment.status == Invoice.PaymentStatus.WAITING){
            Account account = Algorithm.<Account>find(AccountController.accountTable,pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.getRoomId());
            payment.status = Invoice.PaymentStatus.FAILED;
            account.balance += room.price.price;
            return true;
        }
        return false;
    }
    @PostMapping("/submit")
    public boolean submit( @RequestParam int id ){
        return false;
    }
}

