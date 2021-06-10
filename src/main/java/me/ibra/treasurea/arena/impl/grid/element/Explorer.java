package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.element.CanMove;
import me.ibra.treasurea.element.Localizable;
import me.ibra.treasurea.element.Uncrossable;
import me.ibra.treasurea.util.Orientation;

public class Explorer extends GridElementImpl implements Uncrossable, CanMove {

    private final String name;
    private final Orientation orientation;
    private final String moves;

    public Explorer(String name, int x, int y, Orientation orientation, String moves) {
        super(x, y);
        this.name = name;
        this.orientation = orientation;
        this.moves = moves;
    }

    public String name() {
        return name;
    }

    public Orientation orientation() {
        return orientation;
    }

    public String moves() {
        return moves;
    }

    @Override
    public final boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Localizable) {
            Localizable that = (Localizable) other;
            result = that.canEqual(this) && super.equals(that);
        }
        return result;
    }

    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public final boolean canEqual(Object other) {
        return (other instanceof Explorer) ||
                (other instanceof LowLand) ||
                (other instanceof Mountain) ||
                (other instanceof Treasure);
    }
}
