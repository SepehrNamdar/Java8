package functional.interfaces;

import football.player.Player;
import org.junit.jupiter.api.Test;

import java.util.function.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SupplierShould {

    @Test
    void have_any_entry_and_return_a_type() {
        Supplier<Player> hossein = () -> new Player("Hossein", 95);

        assertThat(hossein.get().getName()).isEqualTo("Hossein");
        assertThat(hossein.get().getGoal()).isEqualTo(95);

        int var = -1;

        // DoubleSupplier doubleSupplier;
        // LongSupplier longSupplier;
        // BooleanSupplier booleanSupplier;
        IntSupplier abs = () -> Math.abs(var);
        final int asInt = abs.getAsInt();

        assertThat(asInt).isEqualTo(1);
    }
}
