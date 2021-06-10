package me.ibra.treasurea.util;

import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.util.Step.*;
import static org.junit.jupiter.api.Assertions.*;

public class StepTest {

    private char forwardStepEnglishCharacter  = 'F', forwardStepCharacter  = 'A';
    private char turnLeftStepEnglishCharacter = 'L', turnLeftStepFrenchCharacter = 'G';
    private char turnRightStepEnglishCharacter = 'R', turnRightStepFrenchCharacter = 'D';
    private char illegalCharacter = 'X';

    @Test
    public void shouldSupportEnglishAbbreviationCreation() {
        assertEquals(FORWARD, ofCharacter(forwardStepEnglishCharacter));
        assertEquals(TURN_LEFT, ofCharacter(turnLeftStepEnglishCharacter));
        assertEquals(TURN_RIGHT, ofCharacter(turnRightStepEnglishCharacter));
    }

    @Test
    public void shouldSupportFrenchAbbreviationCreation() {
        assertEquals(FORWARD, ofCharacter(forwardStepEnglishCharacter));
        assertEquals(TURN_LEFT, ofCharacter(turnLeftStepEnglishCharacter));
        assertEquals(TURN_RIGHT, ofCharacter(turnRightStepEnglishCharacter));
    }

    @Test
    public void testNotAllowingCreationOfBlockGridWithHeightOfZero() {
        String expectedExceptionMessage =
                String.format("The character %s is not allowed", illegalCharacter);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            ofCharacter(illegalCharacter);
        });
        assertTrue(thrown.getMessage().contains(expectedExceptionMessage));
    }
}
