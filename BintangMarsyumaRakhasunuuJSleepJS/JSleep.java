package BintangMarsyumaRakhasunuuJSleepJS;








/**
 * Write a description of class JSleep here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 4
 */


public class JSleep{

    public static void main(String[] args){

        Payment testPayment = new Payment(2, 2, 2,2);
        System.out.println(testPayment.getTime());
        System.out.println(testPayment.getDuration());
        Price[] unfilteredArray = new Price[5];
        for(int i=0;i < unfilteredArray.length;i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }
        System.out.println("Price List");
        for(int i=0;i < unfilteredArray.length;i++){
            System.out.println(unfilteredArray[i].price);
        }
        System.out.println("Below 12000.0");
        System.out.println(Validate.filter(unfilteredArray, 12000,true));
        System.out.println("Above 10000.0");
        System.out.println(Validate.filter(unfilteredArray, 10000,false));
    }
    /*public static Room createRoom(){
        Price price = new Price(100000, 100);
        Room room = new Room(231, "HotelKece", 50, price, Facility.AC, City.BEKASI, bedType.SINGLE, "Jalan Gatot Subroto");
        return room;
    }
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


