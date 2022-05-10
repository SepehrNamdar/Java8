package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class UnaryOperatorFunction {

    @Test
    void has_the_same_type_as_entry_and_output() {
        int var = 6;

        UnaryOperator<Integer> tavan = integer -> integer * integer;
        final Integer result = tavan.apply(var);

        assertThat(result).isEqualTo(36);
    }
}
