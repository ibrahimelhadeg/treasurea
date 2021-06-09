package me.ibra.treasurea.arena.impl.grid.element.treasure;

import me.ibra.treasurea.arena.impl.grid.element.GridElementImpl;

public class Treasure extends GridElementImpl {

    private final int number;

    public Treasure(int x, int y, int number) {
        super(x, y);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "T-0-3-2";
    }
}
