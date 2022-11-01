package BintangMarsyumaRakhasunuJSleepJS;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.*;

public class JSleep{


    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }

    public static void main(String[] args){
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jalan Margonda Raya");
        Renter testRegexFail = new Renter("netlab_", "081", "Jalan Margonda Raya");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try{
        String filepath = "src/json/randomRoomList.json";

        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0,5);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }
        //Test Jakarta
        /*try{
        String filepath = "src/json/randomRoomList.json";

        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByCity(tableRoom, "jakarta", 0,5);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*/

        //a filterByPrice jika minPrice = 0 dan maxPrice = 500000.
        /*try{
        String filepath = "src/json/randomRoomList.json";

        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByPrice(tableRoom, 0, 500000);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*/

        //filterByPrice jika minPrice = 100000 dan maxPrice = 250000.
        /*try{
        String filepath = "src/json/randomRoomList.json";
        //filterByPrice jika minPrice = 100000 dan maxPrice = 250000.
        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByPrice(tableRoom, 100000, 250000);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*/

        //a filterByAccountId jika accountId = 1, page = 0 dan pageSize = 5.
        /*try{
        String filepath = "src/json/randomRoomList.json";
        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByAccountId(tableRoom, 1, 0, 5);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*/

        //filterByAccountId jika accountId = 11, page = 0 dan pageSize = 5.
        /*try{
        String filepath = "src/json/randomRoomList.json";
        JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
        List<Room> filterTableRoom = filterByAccountId(tableRoom, 11, 0, 5);
        filterTableRoom.forEach(room-> System.out.println(room.toString()));
        }catch(Throwable t){
            t.printStackTrace();
        }*/

    }
    public static List<Room> filterByCity(List<Room> list, String city, int page, int pageNumber){
        return Algorithm.<Room>paginate(list, page, pageNumber, i -> i.city == City.valueOf(city.toUpperCase()));
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice ){
        return Algorithm.<Room>collect(list, i -> i.price.price >= minPrice && i.price.price <= maxPrice);
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
