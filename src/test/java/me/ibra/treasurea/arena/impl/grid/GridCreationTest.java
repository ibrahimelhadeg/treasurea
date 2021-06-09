package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.impl.grid.element.GridElement;
import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridCreationTest {

    @Test
    void gridCreation() {
        Grid grid = new FixedSizeGrid(3, 4);
        assertEquals(3, grid.getWidth());
        assertEquals(4, grid.getHeight());
        assertEquals("C-3-4", grid.toString());
    }

    @Test
    void lowLandCreation() {
        GridElement gridElement = new LowLand();
        assertEquals(GridElement.WIDTH, gridElement.getWidth());
        assertEquals(GridElement.HEIGHT, gridElement.getHeight());
        assertEquals("P-1-1", gridElement.toString());
    }

    @Test
    void mountainCreation() {
        GridElement gridElement = new Mountain();
        assertEquals(GridElement.WIDTH, gridElement.getWidth());
        assertEquals(GridElement.HEIGHT, gridElement.getHeight());
        assertEquals("M-1-1", gridElement.toString());
    }

    @Test
    void treasureCreation() {
        GridElement gridElement = new Treasure();
        assertEquals(GridElement.WIDTH, gridElement.getWidth());
        assertEquals(GridElement.HEIGHT, gridElement.getHeight());
        assertEquals("T-0-3-2", gridElement.toString());
    }

    @Test
    void explorerCreation() {
        GridElement gridElement = new Explorer();
        assertEquals(GridElement.WIDTH, gridElement.getWidth());
        assertEquals(GridElement.HEIGHT, gridElement.getHeight());
        assertEquals("A-Indiana-1-1-S-AADADA", gridElement.toString());
    }
}
