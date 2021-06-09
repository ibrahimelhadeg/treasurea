package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;
import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.arena.impl.grid.element.GridElement.*;
import static org.junit.jupiter.api.Assertions.*;

public class GridCreationTest {

    @Test
    void should_produce_grid_arena_of_width_three_and_height_four() {
        Grid grid = new FixedSizeGrid(3, 4);
        assertEquals(3, grid.getWidth());
        assertEquals(4, grid.getHeight());
    }

    @Test
    void should_produce_lowland_at_coordinates_one_one_with_default_size() {
        LowLand lowland = new LowLand(1, 1);
        assertEquals(WIDTH, lowland.getWidth());
        assertEquals(HEIGHT, lowland.getHeight());
        assertEquals(1, lowland.getX());
        assertEquals(1, lowland.getY());
    }

    @Test
    void should_produce_mountain_at_coordinates_one_one_with_default_size() {
        Mountain mountain = new Mountain(1, 1);
        assertEquals(WIDTH, mountain.getWidth());
        assertEquals(HEIGHT, mountain.getHeight());
        assertEquals(1, mountain.getX());
        assertEquals(1, mountain.getY());
    }

    @Test
    void should_produce_treasure_of_two_at_coordinates_zero_three_with_default_size() {
        Treasure treasure = new Treasure(0, 3, 2);
        assertEquals(WIDTH, treasure.getWidth());
        assertEquals(HEIGHT, treasure.getHeight());
        assertEquals(0, treasure.getX());
        assertEquals(3, treasure.getY());
        assertEquals(2, treasure.getNumber());
    }

    @Test
    void should_produce_explorer_of_name_Indiana_at_coordinates_one_one_with_default_size() {
        Explorer explorer = new Explorer("Indiana", 1, 1, 'S', "AADADA");
        assertEquals(WIDTH, explorer.getWidth());
        assertEquals(HEIGHT, explorer.getHeight());
        assertEquals("Indiana", explorer.getName());
        assertEquals(1, explorer.getX());
        assertEquals(1, explorer.getY());
        assertEquals('S', explorer.getOrientation());
        assertEquals("AADADA", explorer.getMoves());
    }
}
