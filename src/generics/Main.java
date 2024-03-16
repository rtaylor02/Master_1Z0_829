package generics;

import classdefandreachability.accesscontrolmodifiers.a.P;

public class Main {
    public static void main(String[] args) {
        PlaceHolder.callGetDuplicatePlaceHolder();
    }
}

class PlaceHolder<K, V> {
    private K key;
    private V value;

    public PlaceHolder(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <X> PlaceHolder<X, X> getDuplicatePlaceHolder(X x) {
        //return new PlaceHolder<X, X>(x, x); // OK
        return new PlaceHolder<>(x, x); // OK
    }

    @Override
    public String toString() {
        return this.getClass().getName() + ": " + "key=" + this.key + "; value=" + this.value;
    }

    public static void callGetDuplicatePlaceHolder() {
        PlaceHolder<String, String> a = new PlaceHolder<>("a", "b"); // OK
        //PlaceHolder<String, String> a = new PlaceHolder("a", "b"); // without diamond - OK
        System.out.println(a);

        PlaceHolder<?, ?> b = new PlaceHolder<>("a", "b"); // OK
        //PlaceHolder<?, ?> b = new PlaceHolder(1, "2"); // without diamond - OK
        System.out.println(b);

        var c = new PlaceHolder<>(12, "a"); // OK
        //var c = new PlaceHolder(12, "a"); // without diamond - OK
        System.out.println(c);

        PlaceHolder d = new PlaceHolder("1", 2); // OK
        System.out.println(d);
    }
}