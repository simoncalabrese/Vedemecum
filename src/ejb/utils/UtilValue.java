package ejb.utils;

import java.util.function.Function;

/**
 * Created by user on 19/09/16.
 */
public class UtilValue {

    public static <T> Boolean isNumeric(String value, Function<String, T> number) {
        Boolean result = true;
        try {
            toNumber(value, number);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    public static <T> T toNumber(String value, Function<String, T> convert) {
        return value == null
                ? null
                : convert.apply(value);
    }
}
