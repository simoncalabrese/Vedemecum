package api.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by simon on 05/09/16.
 */
public class UtilDate {

    private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String toString(final LocalDate date) {

        return date != null ? date.format(sdf) : null;
    }

    public static LocalDate toDate(final String date) {
        return date.equals("") ? null : LocalDate.parse(date);
    }
}
