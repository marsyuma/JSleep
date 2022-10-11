package BintangMarsyumaRakhasunuJSleepJS;


import java.util.HashMap;

/**
 * Write a description of class Serializable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Serializable {
    public final int id;
    private static HashMap<Class<?>, Integer > mapCounter = new HashMap<>();
    protected Serializable(){
        Integer counter = mapCounter.get(getClass());
        if(counter == null){
            counter = 0;
        }
        else{
            counter += 1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public static <T extends  Serializable> Integer setClosingId(Class<T> Class, int id){
        return mapCounter.put(Class, id);
    }
    public static <T extends Serializable> Integer getClosingId(Class<T> Class){
        return mapCounter.get(Class);
    }

    public int compareTo(Serializable other){
        return Integer.compare(this.id, other.id);
    }

    public boolean equals(Object obj) {
        return obj instanceof Serializable && ((Serializable) obj).id == this.id;
    }
    public boolean equals(Serializable other){
        return other.id == id;
    }


}