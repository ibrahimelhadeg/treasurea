package me.ibra.treasurea.arena.impl.grid.element.explorer;

import me.ibra.treasurea.arena.impl.grid.element.GridElementImpl;
import me.ibra.treasurea.arena.impl.grid.element.Localizable;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;

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
