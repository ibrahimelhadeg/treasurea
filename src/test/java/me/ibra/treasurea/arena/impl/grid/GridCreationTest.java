package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.impl.grid.element.GridElement;
import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;
import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.arena.impl.grid.element.GridElement.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridCreationTest {

    @Test
    void should_produce_grid_arena_of_width_three_and_height_four() {
        Grid grid = new FixedSizeGrid(3, 4);
        assertEquals(3, grid.getWidth());
        assertEquals(4, grid.getHeight());
        assertEquals("C-3-4", grid.toString());
    }

    @Test
    void should_produce_lowland_at_coordinates_one_one_with_default_size() {
        GridElement gridElement = new LowLand(1, 1);
        assertEquals(WIDTH, gridElement.getWidth());
        assertEquals(HEIGHT, gridElement.getHeight());
        assertEquals(1, gridElement.getX());
        assertEquals(1, gridElement.getY());
        assertEquals("P-1-1", gridElement.toString());
    }

    @Test
    void should_produce_mountain_at_coordinates_one_one_with_default_size() {
        GridElement gridElement = new Mountain(1, 1);
        assertEquals(WIDTH, gridElement.getWidth());
        assertEquals(HEIGHT, gridElement.getHeight());
        assertEquals(1, gridElement.getX());
        assertEquals(1, gridElement.getY());
        assertEquals("M-1-1", gridElement.toString());
    }

    @Test
    void should_produce_treasure_at_coordinates_zero_three_with_default_size() {
        GridElement gridElement = new Treasure(0, 3);
        assertEquals(WIDTH, gridElement.getWidth());
        assertEquals(HEIGHT, gridElement.getHeight());
        assertEquals(0, gridElement.getX());
        assertEquals(3, gridElement.getY());
        assertEquals("T-0-3-2", gridElement.toString());
    }

    @Test
    void should_produce_explorer_of_name_Indiana_at_coordinates_one_one_with_default_size() {
        GridElement gridElement = new Explorer(1, 1);
        assertEquals(WIDTH, gridElement.getWidth());
        assertEquals(HEIGHT, gridElement.getHeight());
        assertEquals(1, gridElement.getX());
        assertEquals(1, gridElement.getY());
        assertEquals("A-Indiana-1-1-S-AADADA", gridElement.toString());
    }
}
