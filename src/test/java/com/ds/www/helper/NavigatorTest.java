package com.ds.www.helper;

import com.ds.www.domain.Move;
import com.ds.www.domain.Orientation;
import org.junit.Test;

public class NavigatorTest {
    Navigator navigator = new Navigator();
    @Test
    public void test_findOrientation_LeftTurn(){
        assert navigator.findOrientation(Move.LEFT, Orientation.NORTH)==Orientation.WEST;
        assert navigator.findOrientation(Move.LEFT, Orientation.SOUTH)==Orientation.EAST;
        assert navigator.findOrientation(Move.LEFT, Orientation.EAST)==Orientation.NORTH;
        assert navigator.findOrientation(Move.LEFT, Orientation.WEST)==Orientation.SOUTH;
    }
    @Test
    public void test_findOrientation_RightTurn(){
        assert navigator.findOrientation(Move.RIGHT, Orientation.NORTH)==Orientation.EAST;
        assert navigator.findOrientation(Move.RIGHT, Orientation.SOUTH)==Orientation.WEST;
        assert navigator.findOrientation(Move.RIGHT, Orientation.EAST)==Orientation.SOUTH;
        assert navigator.findOrientation(Move.RIGHT, Orientation.WEST)==Orientation.NORTH;
    }

    @Test
    public void test_findOrientation_goForward(){
        assert navigator.findOrientation(Move.FORWARD, Orientation.NORTH)==Orientation.NORTH;
        assert navigator.findOrientation(Move.FORWARD, Orientation.SOUTH)==Orientation.SOUTH;
        assert navigator.findOrientation(Move.FORWARD, Orientation.EAST)==Orientation.EAST;
        assert navigator.findOrientation(Move.FORWARD, Orientation.WEST)==Orientation.WEST;
    }
}
