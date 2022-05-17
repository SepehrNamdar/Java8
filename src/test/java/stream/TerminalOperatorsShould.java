package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Comparator.naturalOrder;
import static java.util.UUID.randomUUID;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TerminalOperatorsShould {

    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void collect_data() {   // toList, toMap, toSet, toArray, toCollection
        Function<Player, UUID> keys = player -> randomUUID();
        UnaryOperator<Player> values = player -> player;
        Map<UUID, Player> playersWithId = players.stream().collect(toMap(keys, values));    // collectAndReturn
        BiConsumer<UUID, Player> printPlayer = (k, v) -> out.println("key is " + k + " value is " + v);
        playersWithId.forEach(printPlayer);

        assertThat(playersWithId.values()).hasSameElementsAs(players);
        assertThat(playersWithId.keySet()).hasOnlyElementsOfType(UUID.class);
    }

    @Test
    void calculate_data() {
        final Stream<Integer> goals = players.stream().map(Player::getGoal);
        ToIntFunction<Integer> intConverter = Integer::valueOf;

        final Integer sum = goals.mapToInt(intConverter).sum();

        assertThat(sum).isEqualTo(506);

        final Double average = goals.collect(averagingInt(intConverter));

        assertThat(average).isEqualTo(101.2);

        final Optional<Integer> maxGoalScorer = goals.max(naturalOrder());

        assertThat(maxGoalScorer.get()).isEqualTo(115);

        final Long numberOfElements = goals.count();

        assertThat(numberOfElements).isEqualTo(5);

        final IntSummaryStatistics summary = goals.collect(summarizingInt(intConverter));

        assertThat(summary.getSum()).isEqualTo(506);
        assertThat(summary.getAverage()).isEqualTo(101.2);
        assertThat(summary.getMax()).isEqualTo(115);
        assertThat(summary.getMin()).isEqualTo(84);
        assertThat(summary.getCount()).isEqualTo(5);
    }

    @Test
    void group_data() {
        Function<Player, String> playerName = Player::getName;
        final Map<String, Long> groupedPlayers = players.stream()
                .collect(groupingBy(playerName, counting()));
        groupedPlayers.forEach((k, v) -> out.println("player is " + k + " and has " + v + " occurrences"));

        assertThat(groupedPlayers)
                .containsEntry("Ali Daei", 2L)
                .containsEntry("Cristiano Ronaldo", 1L)
                .containsEntry("Ferenc Puskás", 1L)
                .containsEntry("Mokhtar Dahari", 1L);
    }

    @Test
    void reduce_data() {
        BinaryOperator<Integer> sumOfGoals = Integer::sum;
        final Integer totalGoals = players.stream().map(Player::getGoal).reduce(0, sumOfGoals);

        assertThat(totalGoals).isEqualTo(506);

        final String formattedNames = players.stream()
                .map(Player::getName)
                .reduce("", this::format)
                .replaceFirst("\\|", "")
                .trim();

        assertThat(formattedNames)
                .isEqualTo("Ali DAEI | Ali DAEI | Cristiano RONALDO | Ferenc PUSKÁS | Mokhtar DAHARI");
    }

    private String format(String res, String playerName) {
        final String separator = " ";
        final String firstName = playerName.split(separator)[0];
        final String lastName = playerName.split(separator)[1];
        return res + " | " + firstName + separator + lastName.toUpperCase();
    }
}
