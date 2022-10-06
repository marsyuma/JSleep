package BintangMarsyumaRakhasunuuJSleepJS;


/**
 * Write a description of class JSleep here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 4
 */

import java.sql.Date;

public class JSleep{

    public static void main(String[] args){
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start2 = Date.valueOf("2022-8-15");
        Date end2 = Date.valueOf("2022-8-18");
        /*System.out.println("Membuat booking dari tanggal 20 hingga 22");
        Date start2 = Date.valueOf("2022-8-20");
        Date end2 = Date.valueOf("2022-8-22");*/
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        
        System.out.println(" ");
        
        Room RoomC = JSleep.createRoom();
        Room RoomD = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 18");
        Date start4 = Date.valueOf("2022-8-15");
        Date end4 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start4, end4,RoomC));
        System.out.println("Membuat booking dari tanggal 17 hingga 18");
        Date start5 = Date.valueOf("2022-8-17");
        Date end5 = Date.valueOf("2022-8-18");
        /*System.out.println("Membuat booking dari tanggal 20 hingga 22");
        Date start2 = Date.valueOf("2022-8-20");
        Date end2 = Date.valueOf("2022-8-22");*/
        System.out.println(Payment.makeBooking(start5, end5,RoomC));
        System.out.println("Membuat booking dari tanggal 15 hingga 18 untuk kamar berbeda");
        Date start6 = Date.valueOf("2022-8-18");
        Date end6 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start6, end6 ,RoomD));
    }
    public static Room createRoom(){
        Price price = new Price(100000, 0);
        Room room = new Room(123, "HotelKece", 50, price, Facility.AC, City.BEKASI, "Jalan Gatot Subroto");
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
