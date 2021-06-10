package me.ibra.treasurea.arena.impl.grid;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import me.ibra.treasurea.arena.impl.grid.element.GridElement;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;

import java.util.List;

public class RectangularGridFactory {

    public static RectangularGrid createEmptyGrid(int width, int height) {
        return new RectangularGrid(width, height);
    }

    public static RectangularGrid createGridPopulatedWithLowLands(
            int width, int height) {
        ImmutableGraph.Builder<GridElement> elements = GraphBuilder.directed().immutable();
        for (int horizontal = 0; horizontal < width; horizontal++) {
            for (int vertical = 0; vertical < height; vertical++) {
                LowLand lowLand = new LowLand(horizontal, vertical);
                if (vertical - 1 >= 0) {
                    LowLand northNeighbor = new LowLand(horizontal, vertical - 1);
                    elements.putEdge(lowLand, northNeighbor);
                }
                if (vertical + 1 < height) {
                    LowLand southNeighbor = new LowLand(horizontal, vertical + 1);
                    elements.putEdge(lowLand, southNeighbor);
                }
                if (horizontal - 1 >= 0) {
                    LowLand westNeighbor = new LowLand(horizontal - 1, vertical);
                    elements.putEdge(lowLand, westNeighbor);
                }
                if (horizontal + 1 < width) {
                    LowLand eastNeighbor = new LowLand(horizontal + 1, vertical);
                    elements.putEdge(lowLand, eastNeighbor);
                }
            }
        }
        return new RectangularGrid(width, height, elements.build());
    }

    public static RectangularGrid createGridPopulatedWithCustomElements(
            int width, int height, List<GridElement> customElements) {
        ImmutableGraph.Builder<GridElement> elements = GraphBuilder.directed().immutable();
        customElements.forEach(elements::addNode);
        for (int horizontal = 0; horizontal < width; horizontal++) {
            for (int vertical = 0; vertical < height; vertical++) {
                LowLand lowLand = new LowLand(horizontal, vertical);
                if (vertical - 1 >= 0) {
                    LowLand northNeighbor = new LowLand(horizontal, vertical - 1);
                    elements.putEdge(lowLand, northNeighbor);
                }
                if (vertical + 1 < height) {
                    LowLand southNeighbor = new LowLand(horizontal, vertical + 1);
                    elements.putEdge(lowLand, southNeighbor);
                }
                if (horizontal - 1 >= 0) {
                    LowLand westNeighbor = new LowLand(horizontal - 1, vertical);
                    elements.putEdge(lowLand, westNeighbor);
                }
                if (horizontal + 1 < width) {
                    LowLand eastNeighbor = new LowLand(horizontal + 1, vertical);
                    elements.putEdge(lowLand, eastNeighbor);
                }
            }
        }
        return new RectangularGrid(width, height, elements.build());
    }
}
