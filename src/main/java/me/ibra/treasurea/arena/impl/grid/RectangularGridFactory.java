package me.ibra.treasurea.arena.impl.grid;

import com.google.common.graph.GraphBuilder;
import com.google.common.graph.ImmutableGraph;
import me.ibra.treasurea.arena.impl.grid.element.GridElement;
import me.ibra.treasurea.arena.impl.grid.element.LowLand;

import java.util.Arrays;

public class RectangularGridFactory {

    public static RectangularGrid createGrid(
            int width, int height, GridElement... customElements) {

        ImmutableGraph.Builder<GridElement> graphBuilder = GraphBuilder.directed().immutable();

        if (customElements.length > 0) {
            Arrays.stream(customElements).forEach(graphBuilder::addNode);
        }
        return assembleRectangularGrid(width, height, graphBuilder);
    }

    private static ImmutableGraph<GridElement> fillEmptyNodeOnGraphWithLowLands(
            int width, int height, ImmutableGraph.Builder<GridElement> graphBuilder) {
        for (int horizontal = 0; horizontal < width; horizontal++) {
            for (int vertical = 0; vertical < height; vertical++) {
                LowLand lowLand = new LowLand(horizontal, vertical);
                if (vertical - 1 >= 0) {
                    LowLand northNeighbor = new LowLand(horizontal, vertical - 1);
                    graphBuilder.putEdge(lowLand, northNeighbor);
                }
                if (vertical + 1 < height) {
                    LowLand southNeighbor = new LowLand(horizontal, vertical + 1);
                    graphBuilder.putEdge(lowLand, southNeighbor);
                }
                if (horizontal - 1 >= 0) {
                    LowLand westNeighbor = new LowLand(horizontal - 1, vertical);
                    graphBuilder.putEdge(lowLand, westNeighbor);
                }
                if (horizontal + 1 < width) {
                    LowLand eastNeighbor = new LowLand(horizontal + 1, vertical);
                    graphBuilder.putEdge(lowLand, eastNeighbor);
                }
            }
        }
        return graphBuilder.build();
    }

    private static RectangularGrid assembleRectangularGrid(
            int width, int height, ImmutableGraph.Builder<GridElement> graphBuilder) {
        return new RectangularGrid(
                width, height,
                fillEmptyNodeOnGraphWithLowLands(width, height, graphBuilder));
    }
}
