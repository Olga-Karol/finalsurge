package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class ConvertDateFormat {

    public static String formatDate(String input, String inputFormat, String outputFormat) {
        DateTimeFormatter inputFormatter = stringToDateFormat(inputFormat);
        LocalDate output = LocalDate.parse(input, inputFormatter);
        DateTimeFormatter outputFormatter = stringToDateFormat(outputFormat);
        return output.format(outputFormatter);
    }

    private static DateTimeFormatter stringToDateFormat(String dateFormat){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat, Locale.ENGLISH);
        return formatter;
    }
}

