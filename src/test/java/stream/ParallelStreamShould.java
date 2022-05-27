package stream;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class ParallelStreamShould {

    @Test
    void be_unpredictable() {
        final List<Integer> integers = asList(1, 2, 3, 4, 5);

        out.println("Sequential result is : ");
        integers.stream().forEach(out::print);

        out.println("\nParallel result is : ");
        integers.parallelStream().forEach(out::print);

        final Integer sequentialSum = integers.stream().reduce(5, Integer::sum);
        assertThat(sequentialSum).isEqualTo(20);

        final Integer parallelSum = integers.parallelStream().reduce(5, Integer::sum);
        assertThat(parallelSum).isEqualTo(20);  // 6 + 7 + 8 + 9 + 10 = 40
    }

}
