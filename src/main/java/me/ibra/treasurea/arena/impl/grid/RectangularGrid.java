package me.ibra.treasurea.arena.impl.grid;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import me.ibra.treasurea.arena.impl.grid.element.GridElement;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;

import java.util.List;
import java.util.Optional;

public class RectangularGrid extends RectangularImpl implements Grid {

    private final ImmutableGraph<GridElement> elements;

    RectangularGrid(int width, int height) {
        super(width, height);
        this.elements = GraphBuilder.directed().<GridElement>immutable().build();
    }

    RectangularGrid(int width, int height, ImmutableGraph<GridElement> elements) {
        super(width, height);
        this.elements = elements;
    }

    @Override
    public int getElementsNumber() {
        return elements.nodes().size();
    }

    @Override
    public Optional<GridElement> getElementAt(final int x, final int y) {
        for (GridElement element: elements.nodes()) {
            if (element.getX() == x && element.getY() == y)
                return Optional.of(element);
        }
        return Optional.empty();
    }
}
