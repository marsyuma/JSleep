package com.BintangMarsyumaRakhasunuJSleepJS;


import com.BintangMarsyumaRakhasunuJSleepJS.dbjson.Serializable;

/**
 * Class to process or create Voucher.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 4
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    /**
     * Constructs a new voucher with the given parameters.
     *
     * @param name the name of the voucher
     * @param code the unique code of the voucher
     * @param type the type of the voucher (discount or cashback)
     * @param used whether the voucher has been used or not
     * @param minimum the minimum purchase amount required to use the voucher
     * @param cut the discount or cashback amount offered by the voucher
     */
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut) {
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * Returns whether the voucher has been used or not.
     *
     * @return whether the voucher has been used or not
     */
    public boolean isUsed() {
        return used;
    }

    /**
     * Returns whether the voucher can be applied to the given price.
     *
     * @param price the price to check against
     * @return whether the voucher can be applied to the given price
     */
    public boolean canApply(Price price) {
        if (price.price > minimum && this.used == false) {
            return true;
        }
        return false;
    }

    /**
     * Applies the voucher to the given price and returns the new discounted price.
     *
     * @param price the price to apply the voucher to
     * @return the new discounted price
     */
    public double apply(Price price) {
        this.used = true;
        if (this.type == Type.DISCOUNT) {
            if (this.cut > 100.0) {
                this.cut = 100.0;
                return 0;
            }
            return price.price - (price.price * this.cut / 100);
        } else {
            if (this.cut > price.price) {
                this.cut = price.price;
            }
            return price.price - this.cut;
        }
    }
}