package com.BintangMarsyumaRakhasunuJSleepJS.controller;

import com.BintangMarsyumaRakhasunuJSleepJS.Account;
import com.BintangMarsyumaRakhasunuJSleepJS.Algorithm;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

@RestController
public interface BasicGetController <T extends Serializable> {
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){
        return Algorithm.<T>find(getJsonTable(), pred -> pred.id == id);
    }
    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

}
