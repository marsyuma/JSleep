package BintangMarsyumaRakhasunuJSleepJS;


import java.util.*;


public class Algorithm {

    private Algorithm(){

    }
    public static <T>  List<T> collect(Iterable<T> iterable, T value) {
        Predicate<T> predicate = value::equals;
        return collect(iterable.iterator(), predicate);
    }
    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        return collect(iterable.iterator(), pred);
    }
    public static <T> List<T> collect(T[] array, T value) {
        Predicate<T> predicate = value::equals;
        return collect(array, predicate);
    }
    public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        return collect(Arrays.stream(array).iterator(), pred);
    }
    public static <T> List<T> collect(Iterator<T> iterator, T value) {
        Predicate<T> predicate = value::equals;
        return collect(iterator, predicate);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> list = new ArrayList<>();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (pred.predicate(next)) {
                list.add(next);
            }
        }
        return list;
    }

    //Method count
    public static <T> int count(Iterator<T> iterator, T value){
        Predicate<T> predicate = value::equals;
        return count(iterator, predicate);
    }
    public static <T> int count(T[] array, T value){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, value);
    }
    public static <T> int count(Iterable<T> iterable, Predicate<T> pred){
        Iterator <T> iterator = iterable.iterator();
        return count(iterator, pred);
    }
    public static <T> int count(T[] array, Predicate<T> pred){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return count(iterator, pred);
    }
    public static <T> int count(Iterator<T> iterator, Predicate<T> pred){
        int counter = 0;
        while(iterator.hasNext()){
            if(pred.predicate(iterator.next())) {
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
        while (iterator.hasNext()) {
            if (pred.predicate(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    //Method find
    public static <T> T find(T[] array, T value) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, value);
    }
    public static <T> T find(Iterable<T> iterable, T value) {
        Iterator<T> iterator = iterable.iterator();
        return find(iterator, value);
    }
    public static <T> T find(Iterator<T> iterator, T value) {
        Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }
    public static <T> T find(T[] array, Predicate<T> pred) {
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return find(iterator, pred);
    }
    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        Iterator<T> iterator = iterable.iterator();
        return find(iterator, pred);
    }
    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()){
            if(pred.predicate(iterator.next())){
                return iterator.next();
            }
        }
        return null;
    }
    public <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){
        Iterator<T> iterator = Arrays.stream(array).iterator();
        return paginate(iterator, page, pageSize, pred);
    }
    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
        Iterator<T> iterator = iterable.iterator();
        return paginate(iterator, page, pageSize, pred);
    }
    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
        List<T> list = new ArrayList<T>();
        int counter = page > 1 ? (page-1)*pageSize : 0;
        while(iterator.hasNext()){
            if(pred.predicate(iterator.next())){
                if(counter < pageSize){
                    list.add(iterator.next());
                    counter++;
                }
            }
        }
        return (List<T>) list;
    }
}
