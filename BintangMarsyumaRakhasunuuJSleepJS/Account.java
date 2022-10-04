package BintangMarsyumaRakhasunuuJSleepJS;

/**
 * Write a description of enum Type here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 4
 */
public class Account extends Serializable implements FileParser
{
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String toString(){
        return "Nama : " + this.name + "\nEmail : " + this.email +
                "\nPassword : " + this.password + "\n";
    }
    public Object write() {
        return null;
    }

    public boolean read(String string) {
        return false;
    }
}