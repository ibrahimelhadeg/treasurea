package me.ibra.treasurea.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.util.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacingEastTurningTest {

    private Orientation orientation;
    private Orientation turingLeftOrientation;
    private Orientation turingRightOrientation;

    @BeforeEach
    public void create_facing_east_orientation() {
        orientation = EAST;
        turingLeftOrientation = NORTH;
        turingRightOrientation = SOUTH;
    }

    @Test
    public void test_facing_east_turning_left_by_ninety_degrees_except_north() {
        Orientation newOrientation = orientation.turnLeft();
        assertEquals(turingLeftOrientation, newOrientation);
    }

    @Test
    public void test_facing_east_turning_right_by_ninety_degrees_except_south() {
        Orientation newOrientation = orientation.turnRight();
        assertEquals(turingRightOrientation, newOrientation);
    }
}
