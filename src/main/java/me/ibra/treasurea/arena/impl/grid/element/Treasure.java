package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.element.Collectable;
import me.ibra.treasurea.element.Localizable;
import me.ibra.treasurea.element.Crossable;

public class Treasure extends GridElementImpl implements Crossable, Collectable {

    private final int quantity;

    public Treasure(int x, int y, int quantity) {
        super(x, y);
        this.quantity = quantity;
    }

    public int quantity() {
        return quantity;
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
