package me.ibra.treasurea.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static me.ibra.treasurea.util.Orientation.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacingSouthTurningTest {

    private Orientation orientation;
    private Orientation turingLeftOrientation;
    private Orientation turingRightOrientation;

    @BeforeEach
    public void create_facing_south_orientation() {
        orientation = SOUTH;
        turingLeftOrientation = EAST;
        turingRightOrientation = WEST;
    }

    @Test
    public void test_facing_south_turning_left_by_ninety_degrees_except_east() {
        Orientation newOrientation = orientation.turnLeft();
        assertEquals(turingLeftOrientation, newOrientation);
    }

    @Test
    public void test_facing_south_turning_right_by_ninety_degrees_except_west() {
        Orientation newOrientation = orientation.turnRight();
        assertEquals(turingRightOrientation, newOrientation);
    }
}
