package functional.principles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PureFunctionShould {

    // Method ya function khales :
    // 1 - faghat bayad bastegi be parametr hay khodeshon dashte bashand
    // 2 - bedone side-effect bashe

    // Side-effect :
    // - method ya fuction ma taghiri ijad kone dar kharej az khdesh
    //      - dar yek motagher khoarej az khodesh
    //      - neveshtan dade dar console
    //      - save kardan dade da paygah dade

    @Test
    void depends_only_on_its_parameters() {
        // Method khales
        PureMethod pureMethod = new PureMethod();

        final int sum = pureMethod.sum(1, 3);

        assertThat(sum).isEqualTo(4);

        // Method nakhales
        ImpureMethod impureMethod = new ImpureMethod();

        final int sum2 = impureMethod.sum(1, 3);

        assertThat(sum2).isEqualTo(9);
    }

    @Test
    void has_no_side_effect() {
        ImpureMethod impureMethod = new ImpureMethod();

        final int sum = impureMethod.sum(1, 3);

        assertThat(sum).isEqualTo(9);

        final int res = impureMethod.nakhales_2(2, 3);

        assertThat(res).isEqualTo(5);

        final int sum2 = impureMethod.sum(1, 3);

        assertThat(sum2).isEqualTo(9);
    }
}
