package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.impl.grid.element.Explorer;
import me.ibra.treasurea.arena.impl.grid.element.LowLand;
import me.ibra.treasurea.arena.impl.grid.element.Mountain;
import me.ibra.treasurea.arena.impl.grid.element.Treasure;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridElementEqualsHashTest {

    @Test
    void lowland_should_respect_equals_and_hash_contracts() {
        EqualsVerifier.forClass(LowLand.class)
                .withRedefinedSuperclass()
                .withNonnullFields("coordinates")
                .withOnlyTheseFields("coordinates")
                .verify();
    }

    @Test
    void mountain_should_respect_equals_and_hash_contracts() {
        EqualsVerifier.forClass(Mountain.class)
                .withRedefinedSuperclass()
                .withNonnullFields("coordinates")
                .withOnlyTheseFields("coordinates")
                .verify();
    }

    @Test
    void treasure_should_respect_equals_and_hash_contracts() {
        EqualsVerifier.forClass(Treasure.class)
                .withRedefinedSuperclass()
                .withNonnullFields("coordinates")
                .withOnlyTheseFields("coordinates")
                .verify();
    }

    @Test
    void explorer_should_respect_equals_and_hash_contracts() {
        EqualsVerifier.forClass(Explorer.class)
                .withRedefinedSuperclass()
                .withNonnullFields("name")
                .withOnlyTheseFields("name")
                .verify();
    }

    @Test
    void localizable_elements_should_be_compared_only_based_on_coordinates() {
        LowLand lowLandAtOneOne = new LowLand(1, 1);
        Mountain mountainAtOneOne = new Mountain(1, 1);
        Treasure treasureAtOneOne = new Treasure(1, 1, 2);

        assertEquals(lowLandAtOneOne, mountainAtOneOne);
        assertEquals(lowLandAtOneOne, treasureAtOneOne);

        assertEquals(mountainAtOneOne, lowLandAtOneOne);
        assertEquals(mountainAtOneOne, treasureAtOneOne);

        assertEquals(treasureAtOneOne, lowLandAtOneOne);
        assertEquals(treasureAtOneOne, mountainAtOneOne);
    }
}
