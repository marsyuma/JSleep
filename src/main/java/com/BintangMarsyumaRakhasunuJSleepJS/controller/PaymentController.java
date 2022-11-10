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

    @GetMapping
    public JsonTable getJsonTable(){
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
        Account account = Algorithm.<Account>find(new AccountController().getJsonTable(), pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(new RoomController().getJsonTable(), pred -> pred.id == renterId);
        String status;
        double price = room.price.price;
        boolean lebihBesar = account.balance >= price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = sdf.parse(from);
        Date dateTo = sdf.parse(to);
        Payment payment = new Payment(buyerId, renterId, roomId, dateFrom, dateTo);

        if(account != null && room != null && lebihBesar){
            account.balance -= price;
            payment.status = Invoice.PaymentStatus.WAITING;
            payment.makeBooking(dateFrom, dateTo, room);
            paymentTable.add(payment);
            return payment;
        }

        return null;
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
            Account account = Algorithm.<Account>find(new AccountController().getJsonTable(), pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(new RoomController().getJsonTable(), pred -> pred.id == id);
            payment.status = Invoice.PaymentStatus.FAILED;
            return true;
        }
        return false;
    }
    @PostMapping("/submit")
    public boolean submit( @RequestParam int id ){
        return false;
    }
}

