package me.ibra.treasurea;

import me.ibra.treasurea.arena.impl.grid.Grid;
import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementCreationTest {

    @Test
    void arenaCreation() {
        Element element = ElementFactory.createElement("C-3-4");
        assertTrue(element instanceof Grid);
        assertEquals("C-3-4", element.toString());
    }

    @Test
    void lowLandCreation() {
        Element element = ElementFactory.createElement("P-1-1");
        assertTrue(element instanceof LowLand);
        assertEquals("P-1-1", element.toString());
    }

    @Test
    void mountainCreation() {
        Element element = ElementFactory.createElement("M-1-1");
        assertTrue(element instanceof Mountain);
        assertEquals("M-1-1", element.toString());
    }

    @Test
    void treasureCreation() {
        Element element = ElementFactory.createElement("T-0-3-2");
        assertTrue(element instanceof Treasure);
        assertEquals("T-0-3-2", element.toString() );
    }

    @Test
    void explorerCreation() {
        Element element = ElementFactory.createElement("A-Indiana-1-1-S-AADADA");
        assertTrue(element instanceof Explorer);
        assertEquals("A-Indiana-1-1-S-AADADA", element.toString());
    }
}
