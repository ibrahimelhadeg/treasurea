package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.Arena;
import me.ibra.treasurea.arena.impl.grid.element.GridElement;

import java.util.Optional;

public interface Grid extends Arena, Rectangular {

    int getElementsNumber();

    Optional<GridElement> getElementAt(int x, int y);
}
