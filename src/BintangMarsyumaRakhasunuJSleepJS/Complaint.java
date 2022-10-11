package BintangMarsyumaRakhasunuJSleepJS;


public class Complaint extends Serializable{
    public String date;
    public String desc;

    public Complaint(String date, String desc){
        this.date = date;
        this.desc = desc;
    }
    
    public String toString(){
        return ("Tanggal: " + this.date + "\n" +
                "Deskripsi: " + this.desc + "\n");
    }
}