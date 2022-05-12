package helper;

import football.player.Player;

import java.util.LinkedList;
import java.util.List;

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

}
