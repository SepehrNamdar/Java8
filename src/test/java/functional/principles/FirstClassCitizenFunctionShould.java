package functional.principles;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstClassCitizenFunctionShould {

    // Shahrvand daraje yek
    // 1 - Mishe function ro be onvan parametr yek method estefade kard
    // 2 - Mishe function ro be onvan meghdar be yek moteghayer dad
    // 3 - Mishe yek function be onvan yek meghdar az daroun yek method return beshe

    // Function dar Java = Ebarat lambda (Lambda Expression)
    // (parametr1, parametre2, ...) -> expression
    // () -> expression

    @Test
    void be_passed_as_method_parameter() {
        List<String> players = getPlayers();

        Collections.sort(players, (a, b) -> a.compareTo(b));

        assertPlayersSort(players);
    }

    @Test
    void be_passed_as_value_to_a_variable() {
        List<String> players = getPlayers();

        final Comparator<String> moteghayyer = (a, b) -> a.compareTo(b);
        Collections.sort(players, moteghayyer);

        assertPlayersSort(players);
    }

    @Test
    void be_returned_from_a_method() {
        List<String> players = getPlayers();

        final Comparator<String> moteghayyer = getStringComparator();
        Collections.sort(players, moteghayyer);

        assertPlayersSort(players);
    }

    private Comparator<String> getStringComparator() {
        return (a, b) -> a.compareTo(b);
    }

    private void assertPlayersSort(List<String> players) {
        assertThat(players.get(0)).isEqualTo("Abedzadeh");
        assertThat(players.get(1)).isEqualTo("Majidi");
        assertThat(players.get(2)).isEqualTo("Ronaldo");
    }

    private List<String> getPlayers() {
        List<String> players = new ArrayList<>();
        players.add("Ronaldo");
        players.add("Abedzadeh");
        players.add("Majidi");
        return players;
    }
}
