package me.ibra.treasurea.arena.impl.grid.explorer;

import me.ibra.treasurea.arena.impl.grid.Grid;
import me.ibra.treasurea.arena.impl.grid.element.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.LowLand;
import me.ibra.treasurea.element.Localizable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import java.util.Optional;

import static me.ibra.treasurea.util.Orientation.SOUTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ExplorerFacingSouthMovingForwardTest {

    private Localizable init, next;
    private Explorer explorer;
    private Grid grid;

    @BeforeEach
    public void createExplorer() {
        init = mock(LowLand.class);
        when(init.x()).thenReturn(1);
        when(init.y()).thenReturn(1);

        grid = mock(Grid.class);

        explorer = new Explorer("dummy", init, SOUTH, "A");
    }

    @Test
    public void when_explorer_in_the_middle_try_to_move_to_lowland_or_treasure_position_except_to_be_allowed() {
        next = mock(LowLand.class);
        when(next.x()).thenReturn(1);
        when(next.y()).thenReturn(2);

        doAnswer((Answer<Void>) invocation -> {
            explorer.moveTo(next);
            return null;
        }).when(grid).requestMove(explorer);

        grid.requestMove(explorer);
        assertTrue(explorer.at() instanceof LowLand);
        assertEquals(1, explorer.at().x());
        assertEquals(2, explorer.at().y());
    }

    @Test
    public void when_explorer_in_the_middle_try_to_move_to_mountain_position_except_to_be_denied() {
        doAnswer((Answer<Void>) invocation -> {
            explorer.moveTo(null);
            return null;
        }).when(grid).requestMove(explorer);

        grid.requestMove(explorer);
        assertTrue(explorer.at() instanceof LowLand);
        assertEquals(1, explorer.at().x());
        assertEquals(1, explorer.at().y());
    }
}
