package me.ibra.treasurea;

import me.ibra.treasurea.arena.impl.grid.RectangularGrid;
import me.ibra.treasurea.arena.impl.grid.RectangularGridFactory;
import me.ibra.treasurea.arena.impl.grid.element.GridElement;
import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ElementFactory {

    public static final String ATTRIBUTES_SEPARATOR = "-";

    public static RectangularGrid createEmptyGrid(String arenaStr) {
        String[] arenaProps = arenaStr.split(ATTRIBUTES_SEPARATOR);

        return RectangularGridFactory.createEmptyGrid(
                Integer.parseInt(arenaProps[1]),
                Integer.parseInt(arenaProps[2]));
    }

    public static RectangularGrid createPopulatedGrid(String inputFilledGrid) {
        String[] gridInputLines = inputFilledGrid.split("\\r?\\n");

        String gridPropsLine = gridInputLines[0];
        String[] gridElementsLines = Arrays
                .copyOfRange(gridInputLines, 1, gridInputLines.length);

        String[] gridProps = gridPropsLine.split(ATTRIBUTES_SEPARATOR);
        int gridWidth = Integer.parseInt(gridProps[1]);
        int gridHeight = Integer.parseInt(gridProps[1]);
        List<GridElement> gridElements = Arrays
                .stream(gridElementsLines)
                .map(ElementFactory::createGridElement)
                .collect(Collectors.toList());

        return RectangularGridFactory
                .createGridPopulatedWithCustomElements(
                        gridWidth, gridHeight, gridElements);
    }

    public static GridElement createGridElement(String elmStr) {
        return switch (elmStr.charAt(0)) {
            case 'M' -> createMountain(elmStr);
            case 'T' -> createTreasure(elmStr);
            case 'A' -> createExplorer(elmStr);
            default -> createLowLand();
        };
    }

    private static LowLand createLowLand() {
        return new LowLand(1, 1);
    }

    private static Mountain createMountain(String mountainStr) {
        String[] arenaProps = mountainStr.split(ATTRIBUTES_SEPARATOR);

        return new Mountain(
                Integer.parseInt(arenaProps[1]),
                Integer.parseInt(arenaProps[2]));
    }

    private static Treasure createTreasure(String treasureStr) {
        String[] arenaProps = treasureStr.split(ATTRIBUTES_SEPARATOR);

        return new Treasure(
                Integer.parseInt(arenaProps[1]),
                Integer.parseInt(arenaProps[2]),
                Integer.parseInt(arenaProps[3]));
    }

    private static Explorer createExplorer(String explorerStr) {
        String[] arenaProps = explorerStr.split(ATTRIBUTES_SEPARATOR);

        return new Explorer(
                arenaProps[1],
                Integer.parseInt(arenaProps[2]),
                Integer.parseInt(arenaProps[3]),
                arenaProps[4].charAt(0),
                arenaProps[5]);
    }
}
