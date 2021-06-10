package me.ibra.treasurea;

import me.ibra.treasurea.arena.impl.grid.Grid;
import me.ibra.treasurea.arena.impl.grid.RectangularGrid;
import me.ibra.treasurea.arena.impl.grid.RectangularGridFactory;
import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ElementFactoryTest {

    @Test
    void should_manufacture_lowland_element() {
        try (MockedConstruction<LowLand> mocked =
                     mockConstructionWithAnswer(
                             LowLand.class, invocation -> new LowLand(1, 1))) {
            Element element = ElementFactory.createGridElement("P-1-1");
            assertTrue(element instanceof LowLand);
        }
    }

    @Test
    void should_manufacture_mountain_element() {
        try (MockedConstruction<Mountain> mockedMountain =
                     mockConstructionWithAnswer(
                             Mountain.class, invocation -> new Mountain(1, 1))) {
            Element element = ElementFactory.createGridElement("M-1-1");
            assertTrue(element instanceof Mountain);
        }
    }

    @Test
    void should_manufacture_treasure_element() {
        try (MockedConstruction<Treasure> mockedTreasure =
                     mockConstructionWithAnswer(
                             Treasure.class, invocation -> new Treasure(0, 3, 2))) {
            Element element = ElementFactory.createGridElement("T-0-3-2");
            assertTrue(element instanceof Treasure);
        }
    }

    @Test
    void should_manufacture_explorer_element() {
        try (MockedConstruction<Explorer> mockedExplorer =
                     mockConstructionWithAnswer(
                             Explorer.class, invocation ->
                                     new Explorer("Indiana", 1, 1, 'S', "AADADA"))) {
            Element element = ElementFactory.createGridElement("A-Indiana-1-1-S-AADADA");
            assertTrue(element instanceof Explorer);
        }
    }

    @Test
    void should_manufacture_empty_grid_arena() {
        try (MockedConstruction<RectangularGrid> mockedGrid =
                     mockConstructionWithAnswer(
                             RectangularGrid.class,
                             invocation -> RectangularGridFactory.createEmptyGrid(3, 4))) {
            RectangularGrid emptyGrid = ElementFactory.createEmptyGrid("C-3-4");
            assertNotNull(emptyGrid);
        }
    }

    @Test
    void should_manufacture_populated_grid_arena() {
        Grid grid = mock(RectangularGrid.class);
        try (MockedStatic<RectangularGridFactory> gridFactoryMock =
                     mockStatic(RectangularGridFactory.class)
        ) {
            gridFactoryMock.when(() ->
                    RectangularGridFactory
                            .createGridPopulatedWithCustomElements(
                                    eq(3), eq(4), anyList()))
                    .thenReturn(grid);
            String inputFilledGrid = """
                    C-3-4
                    M-1-0
                    M-2-1
                    T-0-3-2
                    T-1-3-3
                    A-Lara-1-1-S-AADADAGGA
                    """;
            RectangularGrid filledGrid = ElementFactory.createPopulatedGrid(inputFilledGrid);
            assertNotNull(filledGrid);
        }
    }
}
