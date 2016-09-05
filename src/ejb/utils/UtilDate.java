package ejb.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by simon on 05/09/16.
 */
public class UtilDate {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ITALIAN);
    private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.ITALIAN);

    public static String toString(final Date date){
       return sdf.format(date);
    }

    public static Date toDate(final String date) {
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
