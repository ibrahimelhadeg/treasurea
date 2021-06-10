package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridCreationTest {

    @Test
    void should_produce_empty_grid_arena_of_width_three_and_height_four() {
        Grid grid = RectangularGridFactory.createEmptyGrid(3, 4);
        assertEquals(3, grid.getWidth());
        assertEquals(4, grid.getHeight());
    }

    @Test
    void should_manufacture_grid_arena_populated_with_lowlands() {
        Grid filledGrid = RectangularGridFactory.createGridPopulatedWithLowLands(3 , 3);

        assertEquals(9, filledGrid.getElementsNumber());

        assertTrue(filledGrid.getElementAt(0, 0).isPresent());
        assertTrue(filledGrid.getElementAt(0, 0).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(0, 1).isPresent());
        assertTrue(filledGrid.getElementAt(0, 1).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(0, 2).isPresent());
        assertTrue(filledGrid.getElementAt(0, 2).get() instanceof LowLand);

        assertTrue(filledGrid.getElementAt(1, 0).isPresent());
        assertTrue(filledGrid.getElementAt(1, 0).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(1, 1).isPresent());
        assertTrue(filledGrid.getElementAt(1, 1).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(1, 2).isPresent());
        assertTrue(filledGrid.getElementAt(1, 2).get() instanceof LowLand);

        assertTrue(filledGrid.getElementAt(2, 0).isPresent());
        assertTrue(filledGrid.getElementAt(2, 0).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(2, 1).isPresent());
        assertTrue(filledGrid.getElementAt(2, 1).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(2, 2).isPresent());
        assertTrue(filledGrid.getElementAt(2, 2).get() instanceof LowLand);
    }

    @Test
    void should_manufacture_grid_arena_populated_with_custom_elements() {
        Mountain mountainAtOneZero = new Mountain(1, 0);
        Mountain mountainAtTwoOne = new Mountain(2, 1);
        Treasure treasureOfTwoAtZeroThree = new Treasure(0, 3, 2);
        Treasure treasureOfThreeAtOneThree = new Treasure(1, 3, 3);
        Explorer explorerHasNameLaraAtOneOneFacingSouthWithMakingMovesAADADAGGA =
                new Explorer("Lara", 1, 1, 'S', "AADADAGGA");

        Grid filledGrid = RectangularGridFactory
                .createGridPopulatedWithCustomElements(
                        3 , 4,
                        List.of(mountainAtOneZero,
                                mountainAtTwoOne,
                                treasureOfTwoAtZeroThree,
                                treasureOfThreeAtOneThree,
                                explorerHasNameLaraAtOneOneFacingSouthWithMakingMovesAADADAGGA));

        assertEquals(12, filledGrid.getElementsNumber());

        assertTrue(filledGrid.getElementAt(0, 0).isPresent());
        assertTrue(filledGrid.getElementAt(0, 0).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(0, 1).isPresent());
        assertTrue(filledGrid.getElementAt(0, 1).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(0, 2).isPresent());
        assertTrue(filledGrid.getElementAt(0, 2).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(0, 3).isPresent());
        assertTrue(filledGrid.getElementAt(0, 3).get() instanceof Treasure);
        assertEquals(2, ((Treasure) filledGrid.getElementAt(0, 3).get()).getNumber());

        assertTrue(filledGrid.getElementAt(1, 0).isPresent());
        assertTrue(filledGrid.getElementAt(1, 0).get() instanceof Mountain);
        assertTrue(filledGrid.getElementAt(1, 1).isPresent());
        assertTrue(filledGrid.getElementAt(1, 1).get() instanceof Explorer);
        assertEquals("Lara", ((Explorer) filledGrid.getElementAt(1, 1).get()).getName());
        assertEquals('S', ((Explorer) filledGrid.getElementAt(1, 1).get()).getOrientation());
        assertEquals("AADADAGGA", ((Explorer) filledGrid.getElementAt(1, 1).get()).getMoves());
        assertTrue(filledGrid.getElementAt(1, 2).isPresent());
        assertTrue(filledGrid.getElementAt(1, 2).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(1, 3).isPresent());
        assertTrue(filledGrid.getElementAt(1, 3).get() instanceof Treasure);
        assertEquals(3, ((Treasure) filledGrid.getElementAt(1, 3).get()).getNumber());


        assertTrue(filledGrid.getElementAt(2, 0).isPresent());
        assertTrue(filledGrid.getElementAt(2, 0).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(2, 1).isPresent());
        assertTrue(filledGrid.getElementAt(2, 1).get() instanceof Mountain);
        assertTrue(filledGrid.getElementAt(2, 2).isPresent());
        assertTrue(filledGrid.getElementAt(2, 2).get() instanceof LowLand);
        assertTrue(filledGrid.getElementAt(2, 3).isPresent());
        assertTrue(filledGrid.getElementAt(2, 3).get() instanceof LowLand);
    }
}
