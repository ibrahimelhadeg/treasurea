package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.arena.impl.grid.RectangularImpl;
import me.ibra.treasurea.element.Localizable;

import java.awt.*;

public abstract class GridElementImpl extends RectangularImpl implements GridElement, Localizable {

    protected final Point coordinates;

    protected GridElementImpl(int x, int y) {
        super(WIDTH, HEIGHT);
        coordinates = new Point(x, y);
    }

    @Override
    public int x() {
        return coordinates.getLocation().x;
    }

    @Override
    public int y() {
        return coordinates.getLocation().y;
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Localizable) {
            Localizable that = (Localizable) other;
            result = (that.canEqual(this) && this.x() == that.x() && this.y() == that.y());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (41 * (41 + x()) + y());
    }

    public boolean canEqual(Object other) {
        return false;
    }
}
