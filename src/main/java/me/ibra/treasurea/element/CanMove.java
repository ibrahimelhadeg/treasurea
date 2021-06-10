package me.ibra.treasurea.element;

import me.ibra.treasurea.util.Orientation;

import java.util.List;

public interface CanMove {

    Orientation orientation();

    Localizable at();

    void moveTo(Localizable position);
}
