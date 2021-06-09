package me.ibra.treasurea;

import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.FixedSizeGrid;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;

public class ElementFactory {

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
        String[] arenaProps = arenaStr.split("-");
        return new FixedSizeGrid(
                Integer.parseInt(arenaProps[1]), Integer.parseInt(arenaProps[2]));
    }

    private static Element createLowLand() {
        return new LowLand();
    }

    private static Element createMountain(String mountainStr) {
        return new Mountain();
    }

    private static Element createTreasure(String treasureStr) {
        return new Treasure();
    }

    private static Element createExplorer(String explorerStr) {
        return new Explorer();
    }
}
