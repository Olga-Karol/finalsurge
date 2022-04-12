package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ConvertDateFormat {

    public static String convertDateTime(String input, String inputFormat, String outputFormat) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat(inputFormat);
        Date parsedInput = parser.parse(input);
        SimpleDateFormat formatter = new SimpleDateFormat(outputFormat);
        String output = formatter.format(parsedInput);
        return output;
    }
}
