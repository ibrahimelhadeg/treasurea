package me.ibra.treasurea;

import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.FixedSizeGrid;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;

public class ElementFactory {

    public static final String ATTRIBUTES_SEPARATOR = "-";

    public static Element createElement(String elmStr) {
        return switch (elmStr.charAt(0)) {
            case 'C' -> createFixedSizeGridArena(elmStr);
            case 'M' -> createMountain(elmStr);
            case 'T' -> createTreasure(elmStr);
            case 'A' -> createExplorer(elmStr);
            default -> createLowLand();
        };
    }

    private static Element createFixedSizeGridArena(String arenaStr) {
        String[] arenaProps = arenaStr.split(ATTRIBUTES_SEPARATOR);
        return new FixedSizeGrid(
                Integer.parseInt(arenaProps[1]), Integer.parseInt(arenaProps[2]));
    }

    private static Element createLowLand() {
        return new LowLand(1, 1);
    }

    private static Element createMountain(String mountainStr) {
        String[] arenaProps = mountainStr.split(ATTRIBUTES_SEPARATOR);
        return new Mountain(
                Integer.parseInt(arenaProps[1]), Integer.parseInt(arenaProps[2]));
    }

    private static Element createTreasure(String treasureStr) {
        String[] arenaProps = treasureStr.split(ATTRIBUTES_SEPARATOR);
        return new Treasure(
                Integer.parseInt(arenaProps[1]),
                Integer.parseInt(arenaProps[2]),
                Integer.parseInt(arenaProps[3]));
    }

    private static Element createExplorer(String explorerStr) {
        String[] arenaProps = explorerStr.split(ATTRIBUTES_SEPARATOR);
        return new Explorer(
                arenaProps[1],
                Integer.parseInt(arenaProps[2]),
                Integer.parseInt(arenaProps[3]),
                arenaProps[4].charAt(0),
                arenaProps[5]);
    }
}
