package football.player;

import helper.PlayerTestHelper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerShould {

    // Paradigm :   (Daste Bandi)
    //  ...
    //  Imperative Programming : (Barname nevisi Dastouri)
    //      ...
    //      Object Oriented Programming (Shei Gara)
    //  Declarative Programming : (Barname Nevisi Eelani)
    //      ...
    //      Functional Programming : (Barname nevisi Tabeii)
    // ...

    @Test   // Barnme nevisi Object Oriented (Shei Gara)
    void give_the_best_scorer_with_OOP() {   // Behtarin golzn ro be ma tahvil bede
        final List<Player> scorers = new PlayerTestHelper().getPlayers();

        Player bestScorer = scorers.get(0);
        for (Player scorer : scorers) {
            if (scorer.getGoal() > bestScorer.getGoal()) {
                bestScorer = scorer;
            }
        }

        assertThat(bestScorer.getName()).isEqualTo("Cristiano Ronaldo");
    }

    @Test   // Barnme nevisi Functional (Tabei)
    void give_best_scorer_with_FP() {
        final List<Player> scorers = new PlayerTestHelper().getPlayers();

        final Player bestScorer = scorers.stream()
                .max(Comparator.comparing(player -> player.getGoal()))
                .get();

        assertThat(bestScorer.getName()).isEqualTo("Cristiano Ronaldo");
    }

}
