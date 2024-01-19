package datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * This code demonstrates most aspect of java.time.* and java.time.formatter.DateTimeFormatter.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        obtainTimeAndDateOfNow();
        
        trialShiftTime();
        
        trialLocalDateTime();
        
        trialZonedDateTime();
        
        comparison();
    }
    
    /*
    As with compareTo() method, results are:
    -1 ==> 1st parameter comes before 2nd parameter
    0 ==> 1st parameter equal 2nd parameter
    1 ==> 1st parameter comes after 2nd parameter
     */
    private static void comparison() throws InterruptedException {
        var inst1 = Instant.now();
        Thread.sleep(1_000);
        var inst2 = Instant.now();
        System.out.printf(
                "Comparing time(%s) and time(%s): %s",
                inst1,
                inst2,
                inst1.truncatedTo(ChronoUnit.SECONDS).compareTo(inst2.truncatedTo(ChronoUnit.SECONDS))); // -1
    }
    
    private static void trialLocalDateTime() {
        var ld = LocalDate.of(1980, 1, 2);
        System.out.println(ld);
        var lt = LocalTime.of(17,0);
        System.out.println(lt);
        var ldt = LocalDateTime.of(ld, lt);
        System.out.println(ldt);
        LocalDateTime ldt2 = (LocalDateTime)LocalDate.of(2023,07,21).adjustInto(ldt);
        System.out.println(ldt2);
        System.out.println(ldt.getClass().getName());
        System.out.println("----------------");
        System.out.println(ldt);
    }
    
    private static void trialZonedDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Date and time now: " + localDateTime);
        
        var zdt = ZonedDateTime.of(localDateTime, ZoneId.of("America/New_York"));
        System.out.println("Time in America/NY zone now: " + zdt);
        
        var instant = Instant.from(zdt);
        System.out.println("Instant from date and time now: " + instant);
        
        var res2 = instant.adjustInto(zdt);
        System.out.println(res2);
        
        var zdt3 = ZonedDateTime.ofInstant(instant, ZoneId.of("Australia/Sydney"));
        System.out.println(zdt3);
        System.out.println("-----------------------------");
        System.out.println(zdt);
        System.out.println(zdt3);
        System.out.println(zdt.equals(zdt3));
        System.out.println(zdt.toInstant().equals(zdt3.toInstant()));
    }
    
    private static void trialShiftTime() {
        //ZoneId.getAvailableZoneIds().forEach(System.out::println); // Print all ZoneId
        var zi = ZoneId.of("Europe/London");
        System.out.println("Zone id: " + zi);
        //ZoneId.of("Europe/London").getRules().getTransitions().forEach(System.out::println);
        System.out.println("Next time transition: " + zi.getRules().nextTransition(Instant.now()));
        System.out.println("Previous time transition: " + zi.getRules().previousTransition(Instant.now()));
        
        System.out.println(ZonedDateTime.now());
        var shiftTime = ZonedDateTime.parse("2023-03-25T00:00:00+01:00[Europe/Paris]");
        System.out.println(shiftTime);
        System.out.println(shiftTime.plusHours(24));
        System.out.println(shiftTime.plusHours(48));
        System.out.println(shiftTime.plusHours(72));
        System.out.println("--------------------");
        System.out.println(shiftTime.plusDays(1));
        System.out.println(shiftTime.plusDays(2));
        System.out.println(shiftTime.plusDays(3));
    }
    
    private static void obtainTimeAndDateOfNow() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.from(localDateTime);
        //LocalTime localTime = LocalTime.from(localDate); // DateTimeException - cannot create time from date
        LocalTime localTime = LocalTime.from(localDateTime); // OK
        System.out.println("Now is: " + localDateTime);
        System.out.println("Date now is: " + localDate);
        System.out.println("Time now is: " + localTime);
    }
}
