package me.ibra.treasurea.arena.impl.grid.explorer;

import me.ibra.treasurea.arena.impl.grid.element.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.LowLand;
import me.ibra.treasurea.element.Localizable;
import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.util.Orientation.SOUTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExplorerCreationTest {

    @Test
    void should_produce_explorer_of_name_Indiana_at_coordinates_one_one_with_default_size() {
        Localizable init = mock(LowLand.class);
        when(init.x()).thenReturn(1);
        when(init.y()).thenReturn(1);

        Explorer explorer = new Explorer("Indiana", init, SOUTH, "AADADA");
        assertEquals("Indiana", explorer.name());
        assertEquals(1, explorer.at().x());
        assertEquals(1, explorer.at().y());
        assertEquals(SOUTH, explorer.orientation());
        assertEquals("AADADA", explorer.moves());
    }
}
