package me.ibra.treasurea.arena.impl.grid.element;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
                .withNonnullFields("coordinates")
                .withOnlyTheseFields("coordinates")
                .verify();
    }

    @Test
    void localizable_elements_should_be_compared_only_based_on_coordinates() {
        LowLand lowLandAtOneOne = new LowLand(1, 1);
        Mountain mountainAtOneOne = new Mountain(1, 1);
        Treasure treasureAtOneOne = new Treasure(1, 1, 2);
        Explorer explorerAtOneOne = new Explorer("Lara", 1, 1, 'S', "AADADAGGA");

        assertTrue(lowLandAtOneOne.equals(mountainAtOneOne));
        assertTrue(lowLandAtOneOne.equals(treasureAtOneOne));
        assertTrue(lowLandAtOneOne.equals(explorerAtOneOne));

        assertTrue(mountainAtOneOne.equals(lowLandAtOneOne));
        assertTrue(mountainAtOneOne.equals(treasureAtOneOne));
        assertTrue(mountainAtOneOne.equals(explorerAtOneOne));

        assertTrue(treasureAtOneOne.equals(lowLandAtOneOne));
        assertTrue(treasureAtOneOne.equals(mountainAtOneOne));
        assertTrue(treasureAtOneOne.equals(explorerAtOneOne));

        assertTrue(explorerAtOneOne.equals(lowLandAtOneOne));
        assertTrue(explorerAtOneOne.equals(mountainAtOneOne));
        assertTrue(explorerAtOneOne.equals(treasureAtOneOne));
    }
}
