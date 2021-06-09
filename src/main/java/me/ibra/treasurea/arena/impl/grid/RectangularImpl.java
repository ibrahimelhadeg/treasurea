package me.ibra.treasurea.arena.impl.grid;

public abstract class RectangularImpl implements Rectangular {

    private final int width;
    private final int height;

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
