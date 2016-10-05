package ejb.converter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by simon on 31/08/16.
 */
public interface SuperConverter<A, B> extends Function<A, B> {

    B apply(A a);

    default List<B> applyToList(List<A> a){
        return a.stream()
                .map(this::apply)
                .collect(Collectors.toList());
    }

}
