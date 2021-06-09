package me.ibra.treasurea.arena.impl.grid;

public abstract class GridImpl extends RectangularImpl implements Grid {

    protected GridImpl(int width, int height) {
        super(width, height);
    }

    @Override
    public String toString() {
        return String.format("C-%d-%d", getWidth(), getHeight());
    }
}
