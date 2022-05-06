package functional.principles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursiveFunctionShould {

    // Tabe bazgashty : tabei ke khodesh khodesh ro seda bezane ta zamani ke be shart payani berese
    // TODO : sum(5) 1+2+3+4+5 = 15

    // Tamrin : Algorithme Fibonacci

    @Test
    void call_itself() {
        int limit = 5;

        assertThat(iterativeSum(limit)).isEqualTo(15);
        assertThat(recursiveSum(limit)).isEqualTo(15);
        assertThat(tailRecursiveSum(0, limit)).isEqualTo(15);
    }

    private int tailRecursiveSum(int sum, int limit) {
        if (limit == 0) {
            return sum;
        }
        return tailRecursiveSum(sum + limit, limit - 1);
    }

    private int recursiveSum(int limit) {
        if (limit == 0) {
            return limit;
        }
        final int sum = limit + recursiveSum(limit - 1);
        return sum;
    }

    private int iterativeSum(int limit) {
        int sum = 0;
        for (int index = 0; index <= limit; index++) {
            sum += index;
        }
        return sum;
    }
}
