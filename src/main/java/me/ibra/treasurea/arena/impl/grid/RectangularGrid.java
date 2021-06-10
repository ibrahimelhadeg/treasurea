package me.ibra.treasurea.arena.impl.grid;

import com.google.common.graph.ImmutableGraph;
import me.ibra.treasurea.arena.impl.grid.element.GridElement;
import me.ibra.treasurea.element.Localizable;

import java.util.Optional;

public class RectangularGrid extends RectangularImpl implements Grid {

    private final ImmutableGraph<GridElement> elements;

    RectangularGrid(int width, int height, ImmutableGraph<GridElement> elements) {
        super(width, height);
        this.elements = elements;
    }

    @Override
    public int elementsCount() {
        return elements.nodes().size();
    }

    @Override
    public Optional<Localizable> elementAt(final int x, final int y) {
        for (GridElement element: elements.nodes()) {
            if (element.x() == x && element.y() == y)
                return Optional.of(element);
        }
        return Optional.empty();
    }
}
