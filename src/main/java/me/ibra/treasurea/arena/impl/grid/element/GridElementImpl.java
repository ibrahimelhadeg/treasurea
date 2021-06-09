package me.ibra.treasurea.arena.impl.grid.element;

public abstract class GridElementImpl implements GridElement {

    private final String representation;

    protected GridElementImpl(String representation) {
        this.representation = representation;
    }

    @Override
    public String toString() {
        return representation;
    }
}
