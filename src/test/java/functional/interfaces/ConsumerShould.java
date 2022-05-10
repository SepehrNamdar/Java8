package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class ConsumerShould {

    @Test
    void takes_a_entry_and_return_nothing() {
        List<Integer> newNumbers = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(5);

        Consumer<? super Integer> consumer = out::println;  // db.save(integer)
        numbers.forEach(consumer);

        // Assert nadarim

        Consumer<? super Integer> copy = newNumbers::add;
        numbers.forEach(copy);

        assertThat(numbers).isEqualTo(newNumbers);

        // IntConsumer intConsumer;
        // DoubleConsumer doubleConsumer;
        // LongConsumer longConsumer;
    }
}
