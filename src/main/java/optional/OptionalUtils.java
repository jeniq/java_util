package optional;

import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Optional.ofNullable;

public class OptionalUtils {

    public static <T, R> R mapNullable(T value, Function<T, R> mapper) {
        return ofNullable(value)
            .map(mapper)
            .orElse(null);
    }

    public static <T> void consumeIfPresent(T value, Consumer<T> mapper) {
        ofNullable(value)
            .ifPresent(mapper);
    }

}
