package com.ds.www.helper;

import com.ds.www.domain.Move;
import com.ds.www.domain.Orientation;
import java.util.logging.Logger;

public class Navigator {
    private static final Logger LOGGER = Logger.getLogger("Navigator.class");

    public static Orientation findOrientation(Move move, Orientation currentOrientation) {
        switch (move) {
            case LEFT:
                return Mover.moveLeft(currentOrientation);
            case RIGHT:
                return Mover.moveRight(currentOrientation);
            case FORWARD:
                return Mover.moveForward(currentOrientation);
            default:
                return currentOrientation;
        }
    }

    public static int[] getNewPositionAfterMove(int[] currentPosition, Orientation orientation) {
        switch (orientation) {
            case NORTH:
                currentPosition[1] = currentPosition[1] + 1;
                break;
            case SOUTH:
                currentPosition[1] = currentPosition[1] - 1;
                break;
            case EAST:
                currentPosition[0] = currentPosition[0] + 1;
                break;
            case WEST:
                currentPosition[0] = currentPosition[0] - 1;
                break;
            default:
                break;
        }
        return new int[]{currentPosition[0], currentPosition[1]};
    }

    public static Move navigate(char instruction) {
        switch (instruction) {
            case 'F':
                return Move.FORWARD;
            case 'R':
                return Move.RIGHT;
            case 'L':
                return Move.LEFT;
            default:
                return Move.INVALID;
        }
    }

    public static Orientation getOrientation(String input) {
        switch (input) {
            case "N":
                return Orientation.NORTH;
            case "S":
                return Orientation.SOUTH;
            case "E":
                return Orientation.EAST;
            case "W":
                return Orientation.WEST;
            default:
                return null;
        }
    }

    public static String getOrientationString(Orientation orientation) {
        switch (orientation) {
            case NORTH:
                return "N";
            case SOUTH:
                return "S";
            case EAST:
                return "E";
            case WEST:
                return "W";
            default:
                return "U";
        }
    }


}
