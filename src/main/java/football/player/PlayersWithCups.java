package football.player;

import java.util.List;

public class PlayersWithCups extends Player {

    private final List<String> cups;

    public PlayersWithCups(String name, int goal, List<String> cups) {
        super(name, goal);
        this.cups = cups;
    }

    public List<String> getCups() {
        return cups;
    }
}
