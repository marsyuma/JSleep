package BintangMarsyumaRakhasunuJSleepJS;


/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version CS4
 */
import java.util.ArrayList;

public class Validate {
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList result = new ArrayList();
        for (Price price : list) {
            if (less == true) {
                if (price.price <= value) {
                    result.add(price.price);
                }
            } else {
                if (price.price > value) {
                    result.add(price.price);
                }
            }
        }
        return result;

    }
}
