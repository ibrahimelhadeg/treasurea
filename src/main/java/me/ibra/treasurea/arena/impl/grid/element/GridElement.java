package me.ibra.treasurea.arena.impl.grid.element;

import me.ibra.treasurea.arena.Area;
import me.ibra.treasurea.arena.impl.grid.Rectangular;
import me.ibra.treasurea.element.Localizable;

public interface GridElement extends Area, Rectangular, Localizable {

    int WIDTH = 1;
    int HEIGHT = 1;
}
