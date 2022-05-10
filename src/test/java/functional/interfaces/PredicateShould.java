package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicateShould {

    @Test
    void take_a_type_as_entry_and_return_a_boolean() {
        int var = 8;

        Predicate<Integer> isOdd = integer -> integer % 2 == 0;
        final boolean result = isOdd.test(var);

        assertThat(result).isTrue();
    }
}
