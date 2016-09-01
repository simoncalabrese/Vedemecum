package ejb.converter;

import java.util.function.Function;

/**
 * Created by simon on 31/08/16.
 */
public interface SuperConverter<A, B> extends Function<A, B> {

    B apply(A a);

}
