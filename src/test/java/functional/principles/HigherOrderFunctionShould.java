package functional.principles;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HigherOrderFunctionShould {

    // Martabe balatar :
    // 1 - Mitone yek ya chand function ro be onvan parametr begire
    // 2 - Mitone yek function ro bargardone

    @Test
    void take_one_o_many_other_function_as_parmeter_and_return_a_function() {
        // function : adad, operation (function)
        // function (2, + 5) : 7
        Operation operation = number -> number + 5;
        final AddOperationTo addOperationTo = addOperationTo(2, operation);

        final int result = addOperationTo.apply();
        assertThat(result).isEqualTo(7);

        Operation tavan = number -> number * number;
        final AddOperationTo beTavanBeresan = addOperationTo(5, tavan);
        final int adadBeTavan2 = beTavanBeresan.apply();

        assertThat(adadBeTavan2).isEqualTo(25);
    }

    private AddOperationTo addOperationTo(int number, Operation operation) {
        return () -> operation.applyOperation(number);
    }

    @FunctionalInterface
    interface AddOperationTo {
        int apply();
    }

    // Function : SAM (Single Abstract Method)
    @FunctionalInterface
    interface Operation {
        int applyOperation(int number);

        default int another(int number) {
            return 0;
        }
    }

}
