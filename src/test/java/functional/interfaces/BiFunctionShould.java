package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunctionShould {

    @Test
    void takes_two_types_es_entry_and_return_one_type() {
        Map<String, Integer> players = new HashMap<>();
        players.put("Ali", 98);
        players.put("Sahand", 51);

        // key.contains("h") ? value + 1: value - 1
        // Mesle ine ke benevisam
        // if (key.contains("h")) {
        //      value + 1;
        // else {
        //      value - 1;
        // }
        BiFunction<? super String, ? super Integer, Integer> biFunction =
                (key, value) -> key.contains("h") ? value + 1: value - 1;
        final Integer ali = players.compute("Ali", biFunction);
        final Integer sahand = players.compute("Sahand", biFunction);

        assertThat(ali).isEqualTo(97);
        assertThat(sahand).isEqualTo(52);
    }
}
