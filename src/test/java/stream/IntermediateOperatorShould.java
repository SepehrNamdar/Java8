package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class IntermediateOperatorShould {

    private List<Player> players;

    @BeforeEach
    void setUp() {
        players = new PlayerTestHelper().getPlayers();
    }

    @Test
    void filter_data() {
        Predicate<? super Player> topScorer = player -> player.getGoal() > 100;
        Predicate<? super Player> nameIsAli = player -> player.getName().contains("Ali");
        Consumer<? super Player> sideEffect = out::println;
        final List<Player> topScorerWhereNameContainsAli = players.stream()
                .filter(topScorer)
                .peek(sideEffect)
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
                .limit(3)
                .collect(toList());

        final List<Integer> expectedResult = new LinkedList<>();
        expectedResult.add(84);
        expectedResult.add(89);
        expectedResult.add(109);
        /*expectedResult.add(109);
        expectedResult.add(115);*/
        assertThat(sortedScoredGoals).isEqualTo(expectedResult);

        final List<Integer> reversedSortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted(reverseOrder())
                .skip(3)
                .collect(toList());

        final List<Integer> expectedResult_2 = new LinkedList<>();
/*        expectedResult_2.add(115);
        expectedResult_2.add(109);
        expectedResult_2.add(109);*/
        expectedResult_2.add(89);
        expectedResult_2.add(84);
        assertThat(reversedSortedScoredGoals).isEqualTo(expectedResult_2);

        final List<Integer> fourthReversedSortedScoredGoals = players.stream()
                .map(Player::getGoal)
                .sorted(reverseOrder())
                .skip(3)
                .limit(1)
                .collect(toList());

        final List<Integer> expectedResult_3 = new LinkedList<>();
        expectedResult_3.add(89);
        assertThat(fourthReversedSortedScoredGoals).isEqualTo(expectedResult_3);
    }

    @Test
    void be_lazy() {    // farakhani tanbal
        final List<Integer> goals = players.stream()
                .map(Player::getGoal)
                .peek(goal -> out.println("Scored goal is " + goal))
                .filter(goal -> goal < 50)  // Az inja be bad dige kod ejra nemishe
                .peek(goal -> out.println("Never Happen"))
                .map(goal -> goal * 2)
                .collect(toList());

        assertThat(goals).isEmpty();
    }
}
