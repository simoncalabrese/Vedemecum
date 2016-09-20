package ejb.converter;

import java.util.function.BiFunction;

/**
 * Created by user on 20/09/16.
 */
public interface BiSuperConverter<A,B,C> extends BiFunction<A,B,C>{
    C apply(A a,B b);
}
