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
        switch (character) {
            case 'E':
                return EAST;
            case 'N':
                return NORTH;
            case 'S':
                return SOUTH;
            case 'W':
            case 'O':
                return WEST;
            default:
                throw new IllegalArgumentException(
                        String.format("The character %s is not allowed", character));
        }
    }

    public Orientation turnLeft() {
        return ofCharacter(left);
    }

    public Orientation turnRight() {
        return ofCharacter(right);
    }
}
