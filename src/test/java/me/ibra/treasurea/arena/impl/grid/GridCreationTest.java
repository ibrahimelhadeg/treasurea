package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.impl.grid.element.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.Treasure;
import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.util.Orientation.SOUTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridCreationTest {

    @Test
    void should_produce_empty_grid_arena_of_width_three_and_height_four() {
        Grid grid = RectangularGridFactory.createGrid(3, 4);
        assertEquals(3, grid.width());
        assertEquals(4, grid.height());
    }

    @Test
    void should_manufacture_grid_arena_populated_with_lowlands() {
        Grid filledGrid = RectangularGridFactory.createGrid(3 , 3);

        assertEquals(9, filledGrid.elementsCount());

        assertTrue(filledGrid.elementAt(0, 0).isPresent());
        assertTrue(filledGrid.elementAt(0, 0).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(0, 1).isPresent());
        assertTrue(filledGrid.elementAt(0, 1).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(0, 2).isPresent());
        assertTrue(filledGrid.elementAt(0, 2).get() instanceof LowLand);

        assertTrue(filledGrid.elementAt(1, 0).isPresent());
        assertTrue(filledGrid.elementAt(1, 0).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(1, 1).isPresent());
        assertTrue(filledGrid.elementAt(1, 1).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(1, 2).isPresent());
        assertTrue(filledGrid.elementAt(1, 2).get() instanceof LowLand);

        assertTrue(filledGrid.elementAt(2, 0).isPresent());
        assertTrue(filledGrid.elementAt(2, 0).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(2, 1).isPresent());
        assertTrue(filledGrid.elementAt(2, 1).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(2, 2).isPresent());
        assertTrue(filledGrid.elementAt(2, 2).get() instanceof LowLand);
    }

    @Test
    void should_manufacture_grid_arena_populated_with_custom_elements() {
        Mountain mountainAtOneZero = new Mountain(1, 0);
        Mountain mountainAtTwoOne = new Mountain(2, 1);
        Treasure treasureOfTwoAtZeroThree = new Treasure(0, 3, 2);
        Treasure treasureOfThreeAtOneThree = new Treasure(1, 3, 3);
        Explorer explorerHasNameLaraAtOneOneFacingSouthWithMakingMovesAADADAGGA =
                new Explorer("Lara", 1, 1, SOUTH, "AADADAGGA");

        Grid filledGrid = RectangularGridFactory
                .createGrid(
                        3 , 4,
                        mountainAtOneZero,
                        mountainAtTwoOne,
                        treasureOfTwoAtZeroThree,
                        treasureOfThreeAtOneThree,
                        explorerHasNameLaraAtOneOneFacingSouthWithMakingMovesAADADAGGA);

        assertEquals(12, filledGrid.elementsCount());

        assertTrue(filledGrid.elementAt(0, 0).isPresent());
        assertTrue(filledGrid.elementAt(0, 0).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(0, 1).isPresent());
        assertTrue(filledGrid.elementAt(0, 1).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(0, 2).isPresent());
        assertTrue(filledGrid.elementAt(0, 2).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(0, 3).isPresent());
        assertTrue(filledGrid.elementAt(0, 3).get() instanceof Treasure);
        assertEquals(2, ((Treasure) filledGrid.elementAt(0, 3).get()).quantity());

        assertTrue(filledGrid.elementAt(1, 0).isPresent());
        assertTrue(filledGrid.elementAt(1, 0).get() instanceof Mountain);
        assertTrue(filledGrid.elementAt(1, 1).isPresent());
        assertTrue(filledGrid.elementAt(1, 1).get() instanceof Explorer);
        assertEquals("Lara", ((Explorer) filledGrid.elementAt(1, 1).get()).name());
        assertEquals(SOUTH, ((Explorer) filledGrid.elementAt(1, 1).get()).orientation());
        assertEquals("AADADAGGA", ((Explorer) filledGrid.elementAt(1, 1).get()).moves());
        assertTrue(filledGrid.elementAt(1, 2).isPresent());
        assertTrue(filledGrid.elementAt(1, 2).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(1, 3).isPresent());
        assertTrue(filledGrid.elementAt(1, 3).get() instanceof Treasure);
        assertEquals(3, ((Treasure) filledGrid.elementAt(1, 3).get()).quantity());


        assertTrue(filledGrid.elementAt(2, 0).isPresent());
        assertTrue(filledGrid.elementAt(2, 0).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(2, 1).isPresent());
        assertTrue(filledGrid.elementAt(2, 1).get() instanceof Mountain);
        assertTrue(filledGrid.elementAt(2, 2).isPresent());
        assertTrue(filledGrid.elementAt(2, 2).get() instanceof LowLand);
        assertTrue(filledGrid.elementAt(2, 3).isPresent());
        assertTrue(filledGrid.elementAt(2, 3).get() instanceof LowLand);
    }
}
