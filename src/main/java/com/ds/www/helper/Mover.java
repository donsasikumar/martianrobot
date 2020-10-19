package com.ds.www.helper;

import com.ds.www.domain.Orientation;

public class Mover {
    static Orientation moveRight(Orientation orientation){
        switch (orientation){
            case NORTH: return Orientation.EAST;
            case SOUTH: return Orientation.WEST;
            case EAST: return Orientation.SOUTH;
            case WEST: return Orientation.NORTH;
            default:return orientation;
        }
    }

    static Orientation moveLeft(Orientation orientation){
        switch (orientation){
            case NORTH: return Orientation.WEST;
            case SOUTH: return Orientation.EAST;
            case EAST: return Orientation.NORTH;
            case WEST: return Orientation.SOUTH;
            default:return orientation;
        }
    }

    static Orientation moveForward(Orientation orientation){
        return orientation;
    }


}
