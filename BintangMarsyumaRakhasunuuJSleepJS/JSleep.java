package BintangMarsyumaRakhasunuuJSleepJS;





/**
 * Write a description of class JSleep here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */


public class JSleep{

    public static void main(String[] args){
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
    }
    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room("HotelKece", 50, price, Facility.AC);
        return room;
    }
    public static int getHotelId(){
        return 0;
    }
    public static String getHotelName(){
        return "hotel";
    }
    public static boolean isDiscount(){
        return true;
    }
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        if(beforeDiscount <= afterDiscount){
            return 0.0f;
        }
        return (float)(((float)beforeDiscount - (float)afterDiscount) / (float)beforeDiscount * 100);
    }
    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }
        return (int)(price - (price * (discountPercentage / 100.0f)));
    }
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        return (int)((100.0f / (100.0f - discountPercentage)) * (float)discountedPrice);
    }
    public static float getAdminFeePercentage(){
        return 0.05f;
    }
    public static int getAdminFee(int price){
        return (int)(price * getAdminFeePercentage());
    }
    public static int getTotalPrice(int price, int numberOfNight){
        int totalPrice = price * numberOfNight;
        return (totalPrice + getAdminFee(totalPrice));
    }
    
}
