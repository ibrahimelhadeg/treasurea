package me.ibra.treasurea.arena.impl.grid;

import me.ibra.treasurea.arena.Arena;
import me.ibra.treasurea.element.CanMove;
import me.ibra.treasurea.element.Localizable;

import java.util.Optional;

public interface Grid extends Arena, Rectangular {

    int elementsCount();

    Optional<Localizable> elementAt(int x, int y);

    void requestMove(CanMove move);
}
