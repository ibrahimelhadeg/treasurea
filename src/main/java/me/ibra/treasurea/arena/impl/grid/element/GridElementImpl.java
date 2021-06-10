package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.arena.impl.grid.RectangularImpl;

import java.awt.*;

public abstract class GridElementImpl extends RectangularImpl implements GridElement, Localizable {

    protected final Point coordinates;

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

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Localizable) {
            Localizable that = (Localizable) other;
            result = (that.canEqual(this) && this.getX() == that.getX() && this.getY() == that.getY());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (41 * (41 + getX()) + getY());
    }

    public boolean canEqual(Object other) {
        return false;
    }
}
