package util;


import java.util.function.Predicate;

public class Require {
    public static <T> T require(T object, Predicate<T> requirement) {
        if(requirement.test(object)) {
            return object;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
