package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConvertDateFormat {

    public static String convertDateTime(String input, String inputFormat, String outputFormat) {
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
    }

    public static String formatDate(String input, String inputFormat, String outputFormat){
        LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern(inputFormat));
        String output = date.format(DateTimeFormatter.ofPattern(outputFormat));
        return output;
    }

}
