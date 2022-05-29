package stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;

public class StringStreamShould {

    @Test
    void join_strings() {
        final List<String> names = asList("Sepehr", "Ali", "Akbar");

        final String joinedNames = names.stream().collect(joining());
        final String joinedNamesWithComma = names.stream().collect(joining(","));
        final String joinedNamesWithCommaAroundBrackets =
                names.stream().collect(joining(", ", "[", "]"));

        assertThat(joinedNames).isEqualTo("SepehrAliAkbar");
        assertThat(joinedNamesWithComma).isEqualTo("Sepehr,Ali,Akbar");
        assertThat(joinedNamesWithCommaAroundBrackets).isEqualTo("[Sepehr, Ali, Akbar]");
    }
}
