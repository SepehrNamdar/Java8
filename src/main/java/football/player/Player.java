package football.player;

import java.util.Objects;

// Immutable
public class Player {
    private final String name;
    private final int goal;

    // Constructor : misazim
    public Player(String name, int goal) {
        this.name = name;
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public int getGoal() {
        return goal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return goal == player.goal && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, goal);
    }
}
