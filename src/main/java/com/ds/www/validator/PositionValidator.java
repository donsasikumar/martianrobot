package com.ds.www.validator;

import java.util.List;

public class PositionValidator {

    static boolean isOnGrid(int xCordinate,
                     int yCordinate,
                     int xMax,
                     int yMax) {
        return (xCordinate < 0)
                || (xCordinate > xMax)
                || (yCordinate < 0)
                || (yCordinate > yMax) ? false : true;
    }

    static boolean isLostPosition(int xCordinate, int yCordinate, List<String> lostPositions) {
        return lostPositions.contains(xCordinate + "" + yCordinate);
    }


}
