package me.ibra.treasurea.arena.impl.grid.element.treasure;

import me.ibra.treasurea.arena.impl.grid.element.GridElementImpl;

public class Treasure extends GridElementImpl {

    public Treasure(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "T-0-3-2";
    }
}
