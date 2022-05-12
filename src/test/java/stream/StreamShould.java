package stream;

import football.player.Player;
import helper.PlayerTestHelper;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class StreamShould {

    @Test
    void be_created() {
        final String hello = "Hello";

        final Stream<String> helloStream = Stream.of(hello);

        // Assert nadarim

        final Stream<Player> stream = new PlayerTestHelper().getPlayers().stream();
        Integer[] numbers = new Integer[5];
        final Stream<Integer> numbersStream = Arrays.stream(numbers);

        // Assert nadarim
    }

}
