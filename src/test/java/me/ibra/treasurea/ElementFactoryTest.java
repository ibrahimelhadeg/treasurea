package me.ibra.treasurea;

import me.ibra.treasurea.arena.impl.grid.FixedSizeGrid;
import me.ibra.treasurea.arena.impl.grid.Grid;
import me.ibra.treasurea.arena.impl.grid.element.explorer.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.lowland.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.mountain.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.treasure.Treasure;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ElementFactoryTest {

    @Test
    void should_manufacture_grid_arena() {
        try (MockedConstruction<FixedSizeGrid> mockedGrid =
                     mockConstructionWithAnswer(
                             FixedSizeGrid.class, invocation -> new FixedSizeGrid(3, 4))) {
            Element element = ElementFactory.createElement("C-3-4");
            assertTrue(element instanceof Grid);
        }
    }

    @Test
    void should_manufacture_lowland_element() {
        try (MockedConstruction<LowLand> mocked =
                     mockConstructionWithAnswer(
                             LowLand.class, invocation -> new LowLand())) {
            Element element = ElementFactory.createElement("P-1-1");
            assertTrue(element instanceof LowLand);
        }
    }

    @Test
    void should_manufacture_mountain_element() {
        try (MockedConstruction<Mountain> mockedMountain =
                     mockConstructionWithAnswer(
                             Mountain.class, invocation -> new Mountain())) {
            Element element = ElementFactory.createElement("M-1-1");
            assertTrue(element instanceof Mountain);
        }
    }

    @Test
    void should_manufacture_treasure_element() {
        try (MockedConstruction<Treasure> mockedTreasure =
                     mockConstructionWithAnswer(
                             Treasure.class, invocation -> new Treasure())) {
            Element element = ElementFactory.createElement("T-0-3-2");
            assertTrue(element instanceof Treasure);
        }
    }

    @Test
    void should_manufacture_explorer_element() {
        try (MockedConstruction<Explorer> mockedExplorer =
                     mockConstructionWithAnswer(
                             Explorer.class, invocation -> new Explorer())) {
            Element element = ElementFactory.createElement("A-Indiana-1-1-S-AADADA");
            assertTrue(element instanceof Explorer);
        }
    }
}
