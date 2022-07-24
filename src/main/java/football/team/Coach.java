package football.team;

import java.util.Optional;

public class Coach {

    private final Degree degree;

    public Coach(Degree degree) {
        this.degree = degree;
    }

    public Optional<Degree> getDegree() {
        return Optional.ofNullable(degree);
    }
}
