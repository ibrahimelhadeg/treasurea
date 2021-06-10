package me.ibra.treasurea.arena.impl.grid.element.treasure;

import me.ibra.treasurea.arena.impl.grid.element.GridElementImpl;
import me.ibra.treasurea.arena.impl.grid.element.Localizable;
import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;

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
