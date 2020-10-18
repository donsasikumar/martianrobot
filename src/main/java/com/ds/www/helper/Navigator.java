package com.ds.www.helper;

import com.ds.www.domain.Move;
import com.ds.www.domain.Orientation;

public class Navigator {

    Orientation findOrientation( Move move, Orientation currentOrientation){
    switch (move){
        case LEFT: return Mover.moveLeft(currentOrientation);
        case RIGHT: return Mover.moveRight(currentOrientation);
        case FORWARD: return Mover.moveForward(currentOrientation);
        default: return currentOrientation;
    }
    }


}
