package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class OptionalShould {

    // null : Optional, Maybe

    @Test
    void avoid_null_problems() {    // Jelogiri az moshkelat null

        // Before java 8
        Team team = new Team();
        if (team != null) {
            final Coach coach = team.getCoach();
            if (coach != null) {
                final Degree degree = coach.getDegree();
                if (degree != null) {
                    final String value = degree.getValue();

                    out.println(value);
                }
            }
        }
    }
}
