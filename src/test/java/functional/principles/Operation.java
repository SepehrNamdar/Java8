package functional.principles;

// Function : SAM (Single Abstract Method)
@FunctionalInterface
interface Operation {
    int applyOperation(int number);

    default int another(int number) {
        return 0;
    }
}
