package BintangMarsyumaRakhasunuuJSleepJS;





/**
 * Write a description of class JSleep here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */


public class JSleep{

    public static void main(String[] args){
       Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");

        Price testPrice = new Price(100000, 20000);

        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice, Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");

        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");

        Rating testRating = new Rating();

        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());

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
    /*public static Room createRoom(){
        Price price = new Price(100000, 5);
        Room room = new Room(231, "HotelKece", 50, price, Facility.AC, City.BEKASI, bedType.SINGLE, "Jalan Gatot Subroto");
        return room;
    }*/
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
