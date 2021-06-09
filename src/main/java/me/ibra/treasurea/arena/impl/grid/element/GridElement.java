package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.arena.Area;
import me.ibra.treasurea.arena.impl.grid.Rectangular;

public interface GridElement extends Area, Rectangular, Localizable {

    int WIDTH = 1;
    int HEIGHT = 1;
}
