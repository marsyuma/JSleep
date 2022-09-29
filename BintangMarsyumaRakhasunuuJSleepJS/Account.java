package BintangMarsyumaRakhasunuuJSleepJS;

/**
 * Write a description of enum Type here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 2
 */
/**
 * Write a description of enum Type here.
 *
 * @author Bintang Marsyuma Rakhasunu
 * @version Post-Test CS 2
 */
public class Account extends Serializable
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
}