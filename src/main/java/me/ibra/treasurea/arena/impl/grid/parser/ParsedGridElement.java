package me.ibra.treasurea.arena.impl.grid.parser;

public class ParsedGridElement {

    public static class Builder {
        private char type;
        private int width;
        private int height;
        private int x;
        private int y;
        private char orientation;
        private String name;
        private int quantity;
        private String moves;

        public Builder() { }

        public ParsedGridElement build() {
            // any pre-creation validation here
            return new ParsedGridElement(
                    type,
                    width,
                    height,
                    x,
                    y,
                    orientation,
                    name,
                    quantity,
                    moves);
        }

        public Builder type(char type) {
            this.type = type;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Builder orientation(char orientation) {
            this.orientation = orientation;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder occurrences(int occurrences) {
            this.quantity = occurrences;
            return this;
        }

        public Builder moves(String moves) {
            this.moves = moves;
            return this;
        }
    }

    private ParsedGridElement(
            char type, int width, int height, int x, int y,
            char orientation, String name, int quantity, String moves) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.name = name;
        this.quantity = quantity;
        this.moves = moves;
    }

    private final char type;
    private final int width;
    private final int height;
    private final int x;
    private final int y;
    private final char orientation;
    private final String name;
    private final int quantity;
    private final String moves;

    public char type() {
        return type;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public char orientation() {
        return orientation;
    }

    public String name() {
        return name;
    }

    public int occurrences() {
        return quantity;
    }

    public String moves() {
        return moves;
    }
}
