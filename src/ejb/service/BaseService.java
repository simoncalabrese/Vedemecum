package ejb.service;


import model.dao.BaseDaoInterface;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by simon on 31/08/16.
 */
public abstract class BaseService<T extends BaseDaoInterface> {

    public abstract T getDao();

    public <I, O> O converter(I input, Function<I, O> converter) {
        return converter.apply(input);
    }

    public <I, O> List<O> converter(List<I> input, Function<I, O> converter) {
        return input.stream().map(converter).collect(Collectors.toList());
    }

    public <I, L, O> O biconverter(I input1, L input2, BiFunction<I, L, O> converter) {
        return converter.apply(input1, input2);
    }

}
