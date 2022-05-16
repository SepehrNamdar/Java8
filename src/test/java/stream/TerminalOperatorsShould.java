package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.lang.System.out;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Assertions.assertThat;

public class TerminalOperatorsShould {

    @Test
    void collect_data() {   // toList, toMap, toSet, toArray, toCollection
        final List<Player> players = new PlayerTestHelper().getPlayers();

        Function<Player, UUID> keys = player -> randomUUID();
        UnaryOperator<Player> values = player -> player;
        Map<UUID, Player> playersWithId = players.stream().collect(toMap(keys, values));    // collectAndReturn
        BiConsumer<UUID, Player> printPlayer = (k, v) -> out.println("key is " + k + " value is " + v);
        playersWithId.forEach(printPlayer);

        assertThat(playersWithId.values()).hasSameElementsAs(players);
        assertThat(playersWithId.keySet()).hasOnlyElementsOfType(UUID.class);
    }
}
