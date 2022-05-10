package functional.interfaces;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class BiConsumerShould {

    @Test
    void takes_two_entries_and_return_nothing() {
        Map<String, Integer> copyPlayers = new HashMap<>();
        Map<String, Integer> players = new HashMap<>();
        players.put("Majid", 6);
        players.put("Mohsen", 9);

        BiConsumer<? super String, ? super Integer> biConsumer =
                (key, value) -> out.println("player name is " + key +  " and scored " + value + " goals");
        players.forEach(biConsumer);

        // assert nadarim

        BiConsumer<? super String, ? super Integer> copyConsumer = copyPlayers::put;
        players.forEach(copyConsumer);

        assertThat(copyPlayers).isEqualTo(players);

        // ObjLongConsumer objLongConsumer;
        // ObjIntConsumer objIntConsumer;
        // ObjDoubleConsumer objDoubleConsumer;
    }
}
