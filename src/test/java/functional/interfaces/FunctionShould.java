package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionShould {

    // Function:
    // Yek method abstract ke yek type be onvan vorodi daryaft mikone va yek type be onvan khoroji barmigardone

    @Test
    void get_an_entry_and_produce_an_output() {
        Map<String, Integer> map = new HashMap<>();

        Function<? super String, Integer> function = String::length;
        final Integer result = map.computeIfAbsent("Sepehr", function);

        assertThat(result).isEqualTo(6);
    }
}
