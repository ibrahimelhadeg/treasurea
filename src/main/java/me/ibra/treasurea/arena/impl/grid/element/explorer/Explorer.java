package me.ibra.treasurea.arena.impl.grid.element.explorer;

import me.ibra.treasurea.arena.impl.grid.element.GridElementImpl;

public class Explorer extends GridElementImpl {

    private final String name;
    private final char orientation;
    private final String moves;

    public Explorer(String name, int x, int y, char orientation, String moves) {
        super(x, y);
        this.name = name;
        this.orientation = orientation;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public char getOrientation() {
        return orientation;
    }

    public String getMoves() {
        return moves;
    }
}
