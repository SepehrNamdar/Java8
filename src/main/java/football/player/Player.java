package football.player;

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
}
