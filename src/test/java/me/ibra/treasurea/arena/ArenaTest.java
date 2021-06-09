package me.ibra.treasurea.arena;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTest {

    @Test
    void arenaCreation() {
        String arenaElement = ArenaFactory
                .createElement("C-3-4");
        assertEquals(arenaElement, "ARENA");
    }

    @Test
    void lowLandCreation() {
        String arenaElement = ArenaFactory.createElement("P-1-1");
        assertEquals(arenaElement, "LOWLAND");
    }

    @Test
    void mountainCreation() {
        String arenaElement = ArenaFactory
                .createElement("M-1-1");
        assertEquals(arenaElement, "MOUNTAIN");
    }

    @Test
    void treasureCreation() {
        String arenaElement = ArenaFactory
                .createElement("T-0-3-2");
        assertEquals(arenaElement, "TREASURE");
    }

    @Test
    void explorerCreation() {
        String arenaElement = ArenaFactory
                .createElement("A-Indiana-1-1-S-AADADA");
        assertEquals(arenaElement, "EXPLORER");
    }
}
