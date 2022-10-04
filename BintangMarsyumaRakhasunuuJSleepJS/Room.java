package BintangMarsyumaRakhasunuuJSleepJS;


/**
 * Write a description of class Price here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version CS 2
 */

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public String address;
    public Facility facility;
    public BedType bedType;
    public City city;
    public Price price;

    public Room (int id, String name, int size, Price price, Facility facility, City city, String address){
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = bedType.KING;
    }

    public String toString(){
        return "Id : " + this.id + "\nNama : " + this.name +
                "\nSize :" + this.size +
                "\nTipe Kasur : " + this.bedType +
                "\nKota : " + this.city +
                "\nFasilitas : " + this.facility +
                "\nHarga : " + this.price.price + " Rupiah" +
                "\nAlamat : " + this.address + "\n";
    }

    public Object write() {
        return null;
    }

    public boolean read(String string) {
        return false;
    }
}