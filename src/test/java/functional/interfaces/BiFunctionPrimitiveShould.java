package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionPrimitiveShould {

    // ToIntBiFunction
    // ToDoubleBiFunction
    // ToLongBiFunction

    @Test
    void return_a_primitive_type() {
        Integer int1 = 5;
        Integer int2 = 7;

        ToDoubleBiFunction<Integer, Integer> toDoubleBiFunction = Integer::sum;
        final double result = toDoubleBiFunction.applyAsDouble(int1, int2);

        assertThat(result).isEqualTo(12);
    }
}
