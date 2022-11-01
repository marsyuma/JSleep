package BintangMarsyumaRakhasunuJSleepJS;

/**
 * Write a description of enum Type here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 4
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;

    public Account(String name, String email, String password) {
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