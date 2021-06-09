package me.ibra.treasurea.arena;

public class ArenaFactory {

    public static String createElement(String elmStr) {
        return switch (elmStr.charAt(0)) {
            case 'C' -> createArena(elmStr);
            case 'M' -> createMountain(elmStr);
            case 'T' -> createTreasure(elmStr);
            case 'A' -> createExplorer(elmStr);
            default -> createLowLand();
        };
    }

    private static String createArena(String arenaStr) {
        return "ARENA";
    }

    private static String createLowLand() {
        return "LOWLAND";
    }

    private static String createMountain(String mountainStr) {
        return "MOUNTAIN";
    }

    private static String createTreasure(String treasureStr) {
        return "TREASURE";
    }

    private static String createExplorer(String explorerStr) {
        return "EXPLORER";
    }
}
