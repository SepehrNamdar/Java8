package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamOperatorShould {

    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void filter_data() {
        Predicate<? super Player> topScorer = player -> player.getGoal() > 100;
        Predicate<? super Player> nameIsAli = player -> player.getName().contains("Ali");
        final List<Player> topScorerWhereNameContainsAli = players.stream()
                .filter(topScorer)
                .filter(nameIsAli)
                .distinct()     // Dade tekrari ra hazf mikonad
                .collect(toList());

        final List<Player> aliDaei = new LinkedList<>();
        aliDaei.add(new Player("Ali Daei", 109));
        assertThat(topScorerWhereNameContainsAli).isEqualTo(aliDaei);
    }

    @Test
    void map_data() {
        Function<? super Player, ?> function = Player::getName;
        final List<?> playerNames = players.stream()
                .map(function)
                .distinct()     // Dade tekrari ra hazf mikonad
                .collect(toList());

        final List<String> expectedResult = new LinkedList<>();
        expectedResult.add("Ali Daei");
        expectedResult.add("Cristiano Ronaldo");
        expectedResult.add("Ferenc Puskás");
        expectedResult.add("Mokhtar Dahari");
        assertThat(playerNames).isEqualTo(expectedResult);
    }

    @Test
    void sort_data() {
        final List<Integer> sortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted()
                .collect(toList());

        final List<Integer> expectedResult = new LinkedList<>();
        expectedResult.add(84);
        expectedResult.add(89);
        expectedResult.add(109);
        expectedResult.add(109);
        expectedResult.add(115);
        assertThat(sortedScoredGoals).isEqualTo(expectedResult);

        final List<Integer> reversedSortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted(reverseOrder())
                .collect(toList());

        final List<Integer> expectedResult_2 = new LinkedList<>();
        expectedResult_2.add(115);
        expectedResult_2.add(109);
        expectedResult_2.add(109);
        expectedResult_2.add(89);
        expectedResult_2.add(84);
        assertThat(reversedSortedScoredGoals).isEqualTo(expectedResult_2);
    }
}
