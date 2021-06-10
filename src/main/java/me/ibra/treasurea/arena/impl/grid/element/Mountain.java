package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.element.Localizable;
import me.ibra.treasurea.element.Uncrossable;

public class Mountain extends GridElementImpl implements Uncrossable {

    public Mountain(int x, int y) {
        super(x, y);
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
