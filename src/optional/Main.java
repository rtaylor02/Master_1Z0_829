package optional;

import java.util.Optional;

public class Main {

}

class PayDayManager {
    public static void main(String[] args) {
        String payDay = null;
        System.out.println("Is value 'null' present? " + Optional.ofNullable(payDay).isPresent());
        System.out.println("Is value 'null' not present? " + !Optional.ofNullable(payDay).isPresent());
        System.out.println("Is value 'null' empty? " + Optional.ofNullable(payDay).isEmpty());

        Optional<String> optional = Optional.ofNullable(payDay);
        String value = optional.orElse("Bla");
        System.out.println("value = " + value);


        payDay = "Monday";
        System.out.println("Is value 'Monday' present? " + Optional.ofNullable(payDay).isPresent());
        System.out.println("Is value 'Monday' not present? " + !Optional.ofNullable(payDay).isPresent());
        System.out.println("Is value 'Monday' empty? " + Optional.ofNullable(payDay).isEmpty());

        Optional.ofNullable(payDay).ifPresent(s -> {
            String combined = s + s;
            combined = "Hello " + combined;
            System.out.println(combined);
        });
    }

}
