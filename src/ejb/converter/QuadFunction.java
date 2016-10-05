package ejb.converter;

/**
 * Created by simon on 05/10/16.
 */
@FunctionalInterface
public interface QuadFunction<A, B, C, D> {
    D apply(A a, B b, C c);

}
