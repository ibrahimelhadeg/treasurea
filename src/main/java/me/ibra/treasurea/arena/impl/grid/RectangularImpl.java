package me.ibra.treasurea.arena.impl.grid;

public abstract class RectangularImpl implements Rectangular {

    protected final int width;
    protected final int height;

    protected RectangularImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
