package ejb.converter;

/**
 * Created by simon on 05/10/16.
 */
public interface QuadSuperConverter<A,B,C,D> extends QuadFunction<A,B,C,D> {

    @Override
    D apply(A a, B b, C c);
}
