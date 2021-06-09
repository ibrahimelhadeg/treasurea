package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.arena.impl.grid.RectangularImpl;

import java.awt.Point;

public abstract class GridElementImpl extends RectangularImpl implements GridElement, Localizable {

    private final Point coordinates;

    protected GridElementImpl(int x, int y) {
        super(WIDTH, HEIGHT);
        coordinates = new Point(x, y);
    }

    @Override
    public int getX() {
        return coordinates.getLocation().x;
    }

    @Override
    public int getY() {
        return coordinates.getLocation().y;
    }
}
