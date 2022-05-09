package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class PrimitiveFunctionShould {

    @Test
    void get_a_primitive_type_as_entry() {
        int var = 5;

        IntFunction<String> toString = String::valueOf;
        final String result = toString.apply(var);

        assertThat(result).isEqualTo("5");

        DoubleFunction<Float> doubleFunction;
        LongFunction<Integer> longFunction;
    }
}
