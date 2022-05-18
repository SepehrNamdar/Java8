package helper;

import football.player.Player;
import football.player.PlayersWithCups;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class PlayerTestHelper {

    public List<Player> getPlayers() {
        final List<Player> scorers = new LinkedList<>();    // Golzanan
        scorers.add(new Player("Ali Daei", 109));
        scorers.add(new Player("Ali Daei", 109));
        scorers.add(new Player("Cristiano Ronaldo", 115));
        scorers.add(new Player("Ferenc Puskás", 84));
        scorers.add(new Player("Mokhtar Dahari", 89));
        return scorers;
    }

    public List<PlayersWithCups> getPlayersWithCups() {
        final List<PlayersWithCups> scorers = new LinkedList<>();    // Golzanan
        scorers.add(new PlayersWithCups("Ali Daei", 109, asList("Bundes Liga", "Azadegan")));
        scorers.add(new PlayersWithCups("Cristiano Ronaldo", 115, asList("La liga", "European Cup")));
        scorers.add(new PlayersWithCups("Ferenc Puskás", 84, asList("La liga", "European Cup")));
        scorers.add(new PlayersWithCups("Mokhtar Dahari", 89, emptyList()));
        return scorers;
    }

}
