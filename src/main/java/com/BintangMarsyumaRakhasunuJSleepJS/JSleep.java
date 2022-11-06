package com.BintangMarsyumaRakhasunuJSleepJS;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class JSleep{


    /*class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }*/

    public static void main(String[] args){
        SpringApplication.run(JSleep.class, args);

        /*try{
        String filepath = "src/json/Account.json";

        JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
        tableAccount.add(new Account("name", "email", "password"));
        tableAccount.writeJson();
        System.out.println(tableAccount);
        }catch(Throwable t){
            t.printStackTrace();
        }*/

        /*for (int i = 0; i < 10; i++) {
            ThreadingObject thread = new ThreadingObject("Thread " + i);
        }*/

    }
    public static List<Room> filterByCity(List<Room> list, String city, int page, int pageNumber){
        return Algorithm.<Room>paginate(list, page, pageNumber, i -> i.city == City.valueOf(city.toUpperCase()));
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice ){
        return Algorithm.<Room>collect(list, i ->  ((i.price.price >= minPrice) && (i.price.price <= maxPrice)));
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(list, page, pageSize, i -> i.accountId == accountId);
    }
    public static Room createRoom(){
        Price price = new Price(100000, 0.5);
        Room room = new Room(25,"HotelKece", 50, price, Facility.AC, City.BEKASI, "Jalan Gatot Subroto");
        return room;
    }
    /*
    public int getHotelId(){
        return 0;
    }

    public static String getHotelName(){
        return "hotel";
    }

    public static boolean isDiscount(){
        return true;
    }

    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if (beforeDiscount <= afterDiscount){
            return 0.0f;
        } else {
            return (float) ((float)(beforeDiscount - afterDiscount)/(float)beforeDiscount)*100;
        }
    }

    public static int getDiscountedPrice(int price, float discountPercentage){
        if (discountPercentage >= 100.0f){
            return 0;
        } else
            return (int) (price * ((float)100.0 - discountPercentage)/100);
    }

    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        if (discountPercentage >= 100.0f){
            return (int) 0;
        }else
            return (int) ((float)discountedPrice * (100.0 / (100.0 - discountPercentage)));

    }

    public static float getAdminFeePercentage(){
        return 0.05f;
    }

    public static int getAdminFee(int price){
        return (int)((float)price * 0.05f);
    }

    public static int getTotalPrice(int price, int numberOfNight){
        return (price * numberOfNight) + getAdminFee(price * numberOfNight);
    }*/
}
