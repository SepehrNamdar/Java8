package functional.interfaces;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BinaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryOperatorShould {

    @Test
    void have_two_entry_and_one_output_with_the_same_type() {
        int var1 = 4;
        int var2 = 6;

        BinaryOperator<Integer> multiply = (int1, int2) -> int1 * int2;
        final Integer result = multiply.apply(var1, var2);

        assertThat(result).isEqualTo(24);
    }
}
