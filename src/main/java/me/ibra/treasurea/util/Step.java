package me.ibra.treasurea.util;

public enum Step {
    FORWARD, TURN_LEFT, TURN_RIGHT;

    public static Step ofCharacter(char character) {
        return switch (character) {
            case 'F', 'A' -> FORWARD;
            case 'L', 'G' -> TURN_LEFT;
            case 'R', 'D' -> TURN_RIGHT;
            default -> throw new IllegalArgumentException(
                    String.format("The character %s is not allowed", character));
        };
    }
}
