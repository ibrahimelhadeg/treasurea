package me.ibra.treasurea.arena;

public class ArenaFactory {

    public static Element createElement(String elmStr) {
        return switch (elmStr.charAt(0)) {
            case 'C' -> createArena(elmStr);
            case 'M' -> createMountain(elmStr);
            case 'T' -> createTreasure(elmStr);
            case 'A' -> createExplorer(elmStr);
            default -> createLowLand();
        };
    }

    private static Element createArena(String arenaStr) {
        return new Element("ARENA");
    }

    private static Element createLowLand() {
        return new Element("LOWLAND");
    }

    private static Element createMountain(String mountainStr) {
        return new Element("MOUNTAIN");
    }

    private static Element createTreasure(String treasureStr) {
        return new Element("TREASURE");
    }

    private static Element createExplorer(String explorerStr) {
        return new Element("EXPLORER");
    }
}
