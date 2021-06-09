package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.arena.impl.grid.RectangularImpl;

public abstract class GridElementImpl extends RectangularImpl implements GridElement {

    protected GridElementImpl() {
        super(WIDTH, HEIGHT);
    }
}
