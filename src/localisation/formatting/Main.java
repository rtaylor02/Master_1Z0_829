package localisation.formatting;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        double amount = 53_000.35;

        // Formatter into Japanese currency using a factory
        // Not needed if using Locale enums
        //NumberFormat formatter = NumberFormat.getInstance(new Locale("jp", "JP")); // Local(String, String) is deprecated since JDK19
        NumberFormat formatter = NumberFormat.getInstance(Locale.JAPAN); // Preferred way using Locale enums
        if (formatter instanceof DecimalFormat decimalFormat) {
            decimalFormat.setDecimalSeparatorAlwaysShown(true);
        }

        System.out.println(formatter.format(amount));
    }
}
