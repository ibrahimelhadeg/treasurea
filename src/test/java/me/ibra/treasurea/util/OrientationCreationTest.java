package me.ibra.treasurea.util;

import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.util.Orientation.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrientationCreationTest {

    private char southEnglishCharacter = 'S', southFrenchCharacter = 'S';
    private char northEnglishCharacter = 'N', northFrenchCharacter = 'N';
    private char eastEnglishCharacter  = 'E', eastFrenchCharacter  = 'E';
    private char westEnglishCharacter  = 'W', westFrenchCharacter  = 'O';
    private char illegalCharacter = 'X';

    @Test
    public void should_support_english_abbreviation_creation() {
        assertEquals(SOUTH, ofCharacter(southEnglishCharacter));
        assertEquals(NORTH, ofCharacter(northEnglishCharacter));
        assertEquals(EAST, ofCharacter(eastEnglishCharacter));
        assertEquals(WEST, ofCharacter(westEnglishCharacter));
    }

    @Test
    public void should_support_french_abbreviation_creation() {
        assertEquals(SOUTH, ofCharacter(southFrenchCharacter));
        assertEquals(NORTH, ofCharacter(northFrenchCharacter));
        assertEquals(EAST, ofCharacter(eastFrenchCharacter));
        assertEquals(WEST, ofCharacter(westFrenchCharacter));
    }

    @Test
    public void should_not_allow_creation_of_grid_of_zero_with_height() {
        String expectedExceptionMessage =
                String.format("The character %s is not allowed", illegalCharacter);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ofCharacter(illegalCharacter);
        });
        assertTrue(thrown.getMessage().contains(expectedExceptionMessage));
    }
}
