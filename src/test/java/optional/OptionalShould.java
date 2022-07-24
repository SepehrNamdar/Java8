package optional;

import football.team.Coach;
import football.team.Degree;
import football.team.Team;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class OptionalShould {

    // null : Optional, Maybe

    @Test
    void avoid_null_problems() {    // Jelogiri az moshkelat null
        Team team = new Team(new Coach(new Degree("A")));

        // Before java 8
/*        if (team != null) {
            final Optional<Coach> coach = team.getCoach();
            if (coach.isPresent()) {
                final Optional<Degree> degree = coach.get().getDegree();
                final String value = degree.get().getValue();

                assertThat(value).isEqualTo(null);
            }
        }*/

        // From java 8
        team.getCoach()
                .flatMap(Coach::getDegree)
                .map(Degree::getValue)
                .ifPresent(value -> assertThat(value).isEqualTo("A"));
    }

    @Test
    void be_created() {
        String name = "Ahmad";
        assertThat(Optional.of(name).get()).isEqualTo("Ahmad");

        name = null;
        String finalName = name;
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> Optional.of(finalName));
        //assertThat(Optional.of(name).get()).isEqualTo("Ahmad"); --> NPE !

        assertThat(Optional.ofNullable(name)).isEmpty();         // --> NPE nadarim
    }

    @Test
    void have_default_values() {
        String name = "Ahmad";
        out.println("orElse :");
        String result = Optional.ofNullable(name).orElse(getDefaultName());
        out.println(result);
        assertThat(result).isEqualTo("Ahmad");

        out.println("orElseGet :");
        result = Optional.ofNullable(name).orElseGet(this::getDefaultName);
        out.println(result);
        assertThat(result).isEqualTo("Ahmad");
    }

    private String getDefaultName() {
        out.println("default name called");
        return "No name";
    }
}
