package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class ConvertDateFormat {

/*    public static String convertDateTime(String input, String inputFormat, String outputFormat) {
        SimpleDateFormat parser = new SimpleDateFormat(inputFormat);
        Date parsedInput = null;
        try {
            parsedInput = parser.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat formatter = new SimpleDateFormat(outputFormat);
        String output = formatter.format(parsedInput);
        return output;
    }*/

    public static String formatDate(String input, String inputFormat, String outputFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat, Locale.ENGLISH);
        LocalDate output = LocalDate.parse(input, formatter);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern(outputFormat, Locale.ENGLISH);
        return output.format(formatter1);
    }
}

