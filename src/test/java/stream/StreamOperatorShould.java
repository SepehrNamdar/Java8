package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamOperatorShould {

    @Test
    void filter_data() {
        final List<Player> players = new PlayerTestHelper().getPlayers();

        Predicate<? super Player> topScorer = player -> player.getGoal() > 100;
        Predicate<? super Player> nameIsAli = player -> player.getName().contains("Ali");
        final List<Player> topScorerWhereNameContainsAli = players.stream()
                .filter(topScorer)
                .filter(nameIsAli)
                .collect(toList());

        final List<Player> aliDaei = new LinkedList<>();
        aliDaei.add(new Player("Ali Daei", 109));
        assertThat(topScorerWhereNameContainsAli).isEqualTo(aliDaei);
    }
}
