package com.BintangMarsyumaRakhasunuJSleepJS.controller;


import com.BintangMarsyumaRakhasunuJSleepJS.*;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonAutowired;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.BintangMarsyumaRakhasunuJSleepJS.controller.AccountController.accountTable;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class, filepath = "C:\\Main\\Documents\\Kuliah\\Teknik Komputer\\SEMESTER 3\\Pemrograman Berbasis Objek\\Project\\JSleep\\src\\main\\java\\com\\json\\room.json")
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
        @PathVariable int Id,
        @RequestParam int page,
        @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.id == Id);
    }

    @PostMapping("/create")
    public Room createRoom(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
            ) {
        Account account = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == accountId);
        if (account == null) {
            return null;
        }
        Room room = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
        roomTable.add(room);
        return room;
    }
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize

    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }
}
