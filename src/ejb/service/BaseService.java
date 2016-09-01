package ejb.service;


import api.interfaces.BaseServiceInterface;
import model.dao.BaseDaoInterface;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by simon on 31/08/16.
 */
public abstract class BaseService<T extends BaseDaoInterface> implements BaseServiceInterface {

    public abstract T getDao();

    public <I, O> O converter(I input, Function<I, O> converter) {
        return converter.apply(input);
    }

    public <I, O> List<O> converter(List<I> input, Function<I, O> converter) {
        return input.stream().map(converter).collect(Collectors.toList());
    }

}
