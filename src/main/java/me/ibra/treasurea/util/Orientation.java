package me.ibra.treasurea.util;

public enum Orientation {

    EAST('N', 'S'),
    NORTH('W', 'E'),
    SOUTH('E', 'W'),
    WEST('S', 'N');

    char left, right;

    Orientation(char left, char right) {
        this.left = left;
        this.right = right;
    }

    public static Orientation ofCharacter(char character) {
        return switch (character) {
            case 'E' -> EAST;
            case 'N' -> NORTH;
            case 'S' -> SOUTH;
            case 'W', 'O' -> WEST;
            default -> throw new IllegalArgumentException(
                    String.format("The character %s is not allowed", character));
        };
    }

    public Orientation turnLeft() {
        return ofCharacter(left);
    }

    public Orientation turnRight() {
        return ofCharacter(right);
    }
}
