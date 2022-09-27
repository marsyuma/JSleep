package BintangMarsyumaRakhasunuuJSleepJS;





/**
 * Write a description of class JSleep here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */


public class JSleep{

    public static void main(String[] args){
       Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2, 2, 2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());

        Payment testRoom1 = new Payment(2021, 210673, 1848, "18.00", 314, "Saturday", "Monday");
        Invoice testInvoice1 = new Invoice(2021, 210673, 1848, "18.00");
        System.out.println(testRoom1.print());
        System.out.println(testInvoice1.print());

        /*System.out.println("getDiscPercent = " + getDiscountPercentage(1000, 800));
        System.out.println("getDiscPrice = " + getDiscountedPrice(100000, 20.0f));
        System.out.println("getOriginalPrice = " + getOriginalPrice(80000, 20.0f));
        System.out.println("getAdminFee = " + getAdminFee(100000));
        System.out.println("getTotalPrice = " + getTotalPrice(10000, 2));

        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);*/
    }
    public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room(231, "HotelKece", 50, price, Facility.AC);
        return room;
    }
    /*public static int getHotelId(){
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
    }*/
    
}
