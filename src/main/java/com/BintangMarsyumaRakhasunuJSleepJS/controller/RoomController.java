package com.BintangMarsyumaRakhasunuJSleepJS.controller;


import com.BintangMarsyumaRakhasunuJSleepJS.*;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonAutowired;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.BintangMarsyumaRakhasunuJSleepJS.controller.AccountController.accountTable;
/**
 * This class represents a controller for a room.
 * It provides methods create and update a room,
 *
 * @author Bintang MR
 *
 * @implements BasicGetController<Room>
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{
    @JsonAutowired(value = Room.class, filepath = "C:\\Main\\Documents\\Kuliah\\Teknik Komputer\\SEMESTER 3\\Pemrograman Berbasis Objek\\Project\\JSleep\\src\\main\\java\\com\\json\\room.json")
    public static JsonTable<Room> roomTable;

    /**
     * Returns the table of rooms.
     *
     * @return the table of rooms
     */
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    /**
     * Returns a paginated list of rooms rented by the renter with the specified ID.
     *
     * @param Id the ID of the renter
     * @param page the page number to return
     * @param pageSize the number of items per page
     *
     * @return a paginated list of rooms rented by the specified renter
     */
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
        @PathVariable int Id,
        @RequestParam int page,
        @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> pred.id == Id);
    }

    /**
     * Creates a new room with the specified details.
     *
     * @param accountId the ID of the account that owns the room
     * @param name the name of the room
     * @param size the size of the room in square meters
     * @param price the price of the room per night
     * @param facility a list of facilities provided by the room
     * @param city the city in which the room is located
     * @param address the address of the room
     * @param bedType the type of bed in the room
     *
     * @return the newly created room
     */
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
    /**
     * Returns a paginated list of all rooms.
     *
     * @param page the page number to return
     * @param pageSize the number of items per page
     *
     * @return a paginated list of all rooms
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam int page,
            @RequestParam int pageSize

    ){
        System.out.println("masuk");
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, pred -> true);
    }
    @GetMapping
    String index() { return "Index"; }
}
