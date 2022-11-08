package com.BintangMarsyumaRakhasunuJSleepJS.controller;


import com.BintangMarsyumaRakhasunuJSleepJS.Payment;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonAutowired;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(value = Payment.class, filepath = "java/com/json")
    private static JsonTable<Payment> paymentTable;

    @GetMapping
    public JsonTable getJsonTable(){
        return paymentTable;
    }
    @PostMapping("/payment/{id}/create")
    public Payment createPayment(
            @PathVariable int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ){
        return null;
    }
    @PostMapping("/payment/accept")
    public boolean accept( @RequestParam int id ){
        return false;
    }

    @PostMapping("/payment/cancel")
    public boolean cancel(@RequestParam int id  ){
        return false;
    }
    @PostMapping("/payment/submit")
    public boolean submit( @RequestParam int id ){
        return false;
    }
}

