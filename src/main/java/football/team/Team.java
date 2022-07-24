package football.team;

import java.util.Optional;

public class Team {

    private final Coach coach;

    public Team(Coach coach) {
        this.coach = coach;
    }

    public Optional<Coach> getCoach() {
        return Optional.ofNullable(coach);
    }
}
