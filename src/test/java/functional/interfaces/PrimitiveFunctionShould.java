package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimitiveFunctionShould {

    @Test
    void get_a_primitive_type_as_entry() {
        int var = 5;

        IntFunction<String> toString = String::valueOf;
        final String result = toString.apply(var);

        assertThat(result).isEqualTo("5");

        // DoubleFunction<Float> doubleFunction;
        // LongFunction<Integer> longFunction;
    }

    @Test
    void return_a_primitive_type_given_any_type() {
        String var = "3";

        ToIntFunction<String> toIntFunction = string -> Integer.valueOf(string).intValue();
        final int stringToInt = toIntFunction.applyAsInt(var);

        assertThat(stringToInt).isEqualTo(3);

        // ToDoubleFunction<Boolean> toDoubleFunction;
        // ToLongFunction<Long> toLongFunction;
    }
}
