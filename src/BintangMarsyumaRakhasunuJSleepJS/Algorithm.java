package BintangMarsyumaRakhasunuJSleepJS;


import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Algorithm {

    private Algorithm(){

    }
    //Method count
    public static <T> int count(Iterator<T> iterator, T value){
        Predicate<T> predicate = value::equals;
        return count(iterator, predicate);
    }
    public static <T> int count(T[] array, T value){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        Predicate<T> predicate = value::equals;
        return count(iterator, value);
    }
    public static <T> int count(Iterable<T> iterable, Predicate<T> predicate){
        Iterator <T> iterator = iterable.iterator();
        return count(iterator, predicate);
    }
    public static <T> int count(T[] array, Predicate<T> predicate){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, predicate);
    }
    public static <T> int count(Iterator<T> iterator, Predicate<T> predicate){
        int counter = 0;
        while(iterator.hasNext()){
            if(predicate.predicate(iterator.next())) {
                counter++;
            }
        }
        return counter;
    }
    public static <T> int count(Iterable<T> iterable, T value){
        Predicate<T> predicate = value::equals;
        return count(iterable, predicate);
    }
    //Method exists
    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> var = Arrays.stream(array).iterator();
        return exists(var, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> var = iterable.iterator();
        return exists(var, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate <T> var = value::equals;
        return exists(iterator, var);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> var = Arrays.stream(array).iterator();
        return exists(var, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator <T> var = iterable.iterator();
        return exists(var, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        return exists(iterator, pred);
    }
    //Method find
    public static <T> T find(T[] array, T value) {
        for(T i : array){ //For each i in array T compared with value
            if(i == value){
                return i;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, T value) {
        for(T i : iterable){//For each i in iterable T compared with value
            if(i == value){
                return i;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, T value) {
        while (iterator.hasNext()){
            if(iterator.next() == value){
                return iterator.next();
            }
        }
        return null;
    }
    public static <T> T find(T[] array, Predicate<T> pred) {
        for(T i : array){ //For each i in array T, predicate i
            if(pred.predicate(i)){
                return i;
            }
        }
        return null;
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        for(T i : iterable){//For each i in iterable T, predicate i
            if(pred.predicate(i)){
                return i;
            }
        }
        return null;
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            if(pred.predicate(iterator.next())){
                return iterator.next();
            }
        }
        return null;
    }
}
