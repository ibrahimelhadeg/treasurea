package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.impl.grid.element.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.Treasure;
import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.arena.impl.grid.element.GridElement.HEIGHT;
import static me.ibra.treasurea.arena.impl.grid.element.GridElement.WIDTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridElementCreationTest {

    @Test
    void should_produce_lowland_at_coordinates_one_one_with_default_size() {
        LowLand lowland = new LowLand(1, 1);
        assertEquals(WIDTH, lowland.width());
        assertEquals(HEIGHT, lowland.height());
        assertEquals(1, lowland.x());
        assertEquals(1, lowland.y());
    }

    @Test
    void should_produce_mountain_at_coordinates_one_one_with_default_size() {
        Mountain mountain = new Mountain(1, 1);
        assertEquals(WIDTH, mountain.width());
        assertEquals(HEIGHT, mountain.height());
        assertEquals(1, mountain.x());
        assertEquals(1, mountain.y());
    }

    @Test
    void should_produce_treasure_of_two_at_coordinates_zero_three_with_default_size() {
        Treasure treasure = new Treasure(0, 3, 2);
        assertEquals(WIDTH, treasure.width());
        assertEquals(HEIGHT, treasure.height());
        assertEquals(0, treasure.x());
        assertEquals(3, treasure.y());
        assertEquals(2, treasure.quantity());
    }

    @Test
    void should_produce_explorer_of_name_Indiana_at_coordinates_one_one_with_default_size() {
        Explorer explorer = new Explorer("Indiana", 1, 1, 'S', "AADADA");
        assertEquals(WIDTH, explorer.width());
        assertEquals(HEIGHT, explorer.height());
        assertEquals("Indiana", explorer.name());
        assertEquals(1, explorer.x());
        assertEquals(1, explorer.y());
        assertEquals('S', explorer.orientation());
        assertEquals("AADADA", explorer.moves());
    }
}
