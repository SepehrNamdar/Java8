package functional.principles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ImmutableFunctionShould {

    // Taghir napiziri : vaghty chizi dorost msihe, bad az an digar taghir nakonad

    @Test
    void never_be_changed_after_being_constructed() {
        final int var = 5;      // dorost shode
        //var++;                // taghir meghdar
        Operation operation = number -> number + var;
        final AddOperationTo addOperationTo = addOperationTo(2, operation);

        final int result = addOperationTo.apply();
        assertThat(result).isEqualTo(7);
    }

    private AddOperationTo addOperationTo(int number, Operation operation) {
        return () -> operation.applyOperation(number);
    }
}
