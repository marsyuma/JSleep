package com.BintangMarsyumaRakhasunuJSleepJS.controller;

import com.BintangMarsyumaRakhasunuJSleepJS.Account;
import com.BintangMarsyumaRakhasunuJSleepJS.Algorithm;
import com.BintangMarsyumaRakhasunuJSleepJS.Renter;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonAutowired;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    @JsonAutowired(value = Account.class, filepath = "java/com/json")
    public static JsonTable<Account> accountTable;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final String REGEX_PATTERN_EMAIL = null;
    public static final String REGEX_PATTERN_PASSWORD = null;

    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @GetMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) {
        Account account = Algorithm.<Account>find((Iterator<Account>) accountTable, pred -> pred.email == email && pred.password == password);
        if (account != null) {
            return account;
        }
        return null;
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            ) {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchEmail = matcherEmail.find();

        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchFoundPassword = matcherPassword.find();
        if (matchEmail && matchFoundPassword && !name.isBlank()) {
            return new Account(name, email, password);
        } else {
            return null;
        }
    }
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @PathVariable int id,
            @RequestParam String username,
            @RequestParam String address
    ) {
        Account account = Algorithm.<Account>find(accountTable, id, pred -> pred.id == id);
        if (account != null) {
            return new Renter(username, address, address);
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance) {
        Account account = Algorithm.<Account>find((Iterator<Account>) accountTable, pred -> pred.id == id);
        if (account != null) {
            account.balance += balance;
            return true;
        }
        return false;
    }
}
