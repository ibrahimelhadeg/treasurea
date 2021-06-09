package me.ibra.treasurea.arena.impl.grid;

public abstract class GridImpl implements Grid {

    private final String representation;

    protected GridImpl(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }
}
