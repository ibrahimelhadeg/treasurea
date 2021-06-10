package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.element.CanMove;
import me.ibra.treasurea.element.Localizable;
import me.ibra.treasurea.element.Uncrossable;
import me.ibra.treasurea.util.Orientation;

import java.util.List;
import java.util.Stack;

public class Explorer implements Uncrossable, CanMove {

    private final Stack<Localizable> ats = new Stack<>();
    private final String name;
    private final Orientation orientation;
    private final String moves;

    public Explorer(String name, Localizable initAt, Orientation orientation, String moves) {
        this.name = name;
        this.orientation = orientation;
        this.moves = moves;
        this.moveTo(initAt);
    }

    public String name() {
        return name;
    }

    @Override
    public Orientation orientation() {
        return orientation;
    }

    @Override
    public Localizable at() {
        return ats.peek();
    }

    @Override
    public void moveTo(Localizable at) {
        if (at != null) {
            this.ats.push(at);
        }
    }

    public String moves() {
        return moves;
    }

    @Override
    public final boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Explorer) {
            Explorer that = (Explorer) other;
            result = name().equals(that.name());
        }
        return result;
    }

    @Override
    public final int hashCode() {
        return name().hashCode();
    }
}
