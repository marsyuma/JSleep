package com.BintangMarsyumaRakhasunuJSleepJS;

import java.util.List;

import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonDBEngine;
import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The `JSleep` class represents the main class of the JSleep hotel booking system.
 *
 * @author Bintang MR
 * @version PT Modul 8
 */
@SpringBootApplication
public class JSleep{


    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main(String[] args) {
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }

    /**
     * Filters a list of rooms by city and returns a paginated result.
     *
     * @param list the list of rooms to filter
     * @param city the city to filter by
     * @param page the page number of the paginated result
     * @param pageNumber the number of items per page
     * @return the paginated list of rooms
     */
    public static List<Room> filterByCity(List<Room> list, String city, int page, int pageNumber){
        return Algorithm.<Room>paginate(list, page, pageNumber, i -> i.city == City.valueOf(city.toUpperCase()));
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice ){
        return Algorithm.<Room>collect(list, i -> i.price.price >= minPrice && i.price.price <= maxPrice);
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(list, page, pageSize, i -> i.accountId == accountId);
    }
    public static List<Room> filterByHotelId(List<Room> list, int hotelId, int page, int pageSize){
        return Algorithm.<Room>paginate(list, page, pageSize, i -> i.id == hotelId);
    }
    public static List<Room> filterByHotelName(List<Room> list, String hotelName, int page, int pageSize){
        return Algorithm.<Room>paginate(list, page, pageSize, i -> i.name == hotelName);
    }

}
