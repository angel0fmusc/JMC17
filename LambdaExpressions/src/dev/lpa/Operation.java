package dev.lpa;

/**
 * A functional interface (has 1 abstract method) that is generic
 * (can work with any type)
 * @param <T> - A generic type
 */
@FunctionalInterface
public interface Operation<T>{

    /*
    * Abstract method that takes two values of the same type and
    * returns a value that is also the same type as the parameters
    * */
    T operate(T value1, T value2);
}
