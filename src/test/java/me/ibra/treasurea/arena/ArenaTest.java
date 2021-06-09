package me.ibra.treasurea.arena;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArenaTest {

    @Test
    void arenaCreation() {
        Element element = ArenaFactory.createElement("C-3-4");
        assertEquals("ARENA", element.toString());
    }

    @Test
    void lowLandCreation() {
        Element element = ArenaFactory.createElement("P-1-1");
        assertEquals("LOWLAND", element.toString());
    }

    @Test
    void mountainCreation() {
        Element element = ArenaFactory.createElement("M-1-1");
        assertEquals("MOUNTAIN", element.toString());
    }

    @Test
    void treasureCreation() {
        Element element = ArenaFactory.createElement("T-0-3-2");
        assertEquals("TREASURE", element.toString() );
    }

    @Test
    void explorerCreation() {
        Element element = ArenaFactory.createElement("A-Indiana-1-1-S-AADADA");
        assertEquals("EXPLORER", element.toString());
    }
}
