package localisation;

import classdefandreachability.accesscontrolmodifiers.c.R;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Lesson 31.1 on Simon Roberts' OCP 1z0-829 OReilly course
 *
 * This code demonstrates formatting and use of locale.
 *
 * This code also demonstrates how ResourceBundle uses data provided to it and sorts out any mismatch in the resources.
 *
 */
public class Main {
    public static void main(String[] args) {
        //showFormatting();
        
        //parsingDates();
        
        //usingResourceBundle();
        
        resourcesWithIncorrectName();
        
        resourceWithNonExistingKey();
    }
    
    private static void resourceWithNonExistingKey() {
        try {
            ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("localisation.MyResources");
            System.out.println("non-existing key: " + resourceBundle.getString("missing"));
        } catch (Exception e) {
            System.out.println("get of missing resource failed with: " + e);
        }
    }
    
    private static void resourcesWithIncorrectName() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("BadName");
        } catch (Exception e) {
            System.out.println("get of resource bundle \"BadName\" failed with " + e);
        }
    }
    
    /**
     * This method demonstrates how ResourceBundle uses data provided to it and sorts out any mismatch in the resources.
     */
    private static void usingResourceBundle() {
        List<Locale> locales = new ArrayList<>(Arrays.asList(
                Locale.CANADA,
                Locale.US,
                Locale.UK,
                Locale.GERMANY));
        
        for (Locale locale : locales) {
            Locale.setDefault(locale);
            
            System.out.println("For locale: " + locale + "-----------------");
            
            ResourceBundle resourceBundle = PropertyResourceBundle.getBundle("localisation.MyResources");
            
            System.out.println("car-engine cover: " + resourceBundle.getString("car-engine-cover"));
            System.out.println("cake: " + resourceBundle.getString("cake"));
            System.out.println("baked-item: " + resourceBundle.getString("baked-item"));
            System.out.println("affirmation: " + resourceBundle.getString("affirmation"));
            
            System.out.println("-----------------------------");
        }
    }
    
    private static void parsingDates() {
        LocalDate localDate = LocalDate.of(1980, 1, 2);
        
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(formatter.format(localDate));
        
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d MMMM yyyy");
        System.out.println(formatter1.format(localDate));
        
        String date = "1 February 1981";
        TemporalAccessor temporalAccessor = formatter1.parse(date);
        System.out.println(formatter.format(temporalAccessor));
    }
    
    /**
     * Even if you mix the sentence up, the indexing (%n$) will know which word to put in the specified place.
     */
    private static void showFormatting() {
        String template = "the %2$s meteor can be seen in the month of %1$tb.\nIf you're patient, you can expect to see %3$,8.1f shooting stars\n";
        Month month = Month.AUGUST;
        String showerName = "Perseid";
        System.out.printf(Locale.CANADA, template, month, showerName, 1_000.0); // Notice the comma being used for thousands separator.
        System.out.printf(Locale.FRENCH, template, month, showerName, 1_000.0); // French ==> Notice use of aout & comma instead for decimal point.
    }
}
