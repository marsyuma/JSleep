package BintangMarsyumaRakhasunuJSleepJS;


/**
 * Write a description of class Voucher here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 4
 */
public class Voucher extends Serializable implements FileParser
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }


    public boolean isUsed() {
        return used;
    }

    public boolean canApply(Price price){
        if (price.price > minimum && this.used == false){
            return true;
        }
        return false;
    }

    public double apply(Price price){
        this.used = true;
        if (this.type == Type.DISCOUNT){
            if(this.cut > 100.0){
                this.cut = 100.0;
                return 0;
            }
            return price.price - (price.price * this.cut / 100);
        }
        else {
            if (this.cut > price.price){
                this.cut = price.price;
            }
            return price.price - this.cut;
        }
    }

    public Object write() {
        return null;
    }

    public boolean read(String string) {
        return false;
    }
}