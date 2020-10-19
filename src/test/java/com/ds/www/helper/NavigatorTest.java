package com.ds.www.helper;

import com.ds.www.domain.Move;
import com.ds.www.domain.Orientation;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


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

    @Test
    public void test_navigate(){
        assert navigator.navigate('F').equals(Move.FORWARD);
        assert navigator.navigate('R').equals(Move.RIGHT);
        assert navigator.navigate('L').equals(Move.LEFT);
        assert navigator.navigate('A').equals(Move.INVALID);

    }

    @Test
    public void testMoveForward_North(){
        int[] initialCordinates = {1,1};
        int[] arr = navigator.getNewPositionAfterMove(initialCordinates, Orientation.NORTH);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 1 || arr[1] == 2);
    }
    @Test
    public void testMoveForward_South(){
        int[] initialCordinates = {1,1};
        int[] arr = navigator.getNewPositionAfterMove(initialCordinates,Orientation.SOUTH);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 1 || arr[1] == 0);
    }

    @Test
    public void testMoveForward_East(){
        int[] initialCordinates = {1,1};
        int[] arr = navigator.getNewPositionAfterMove(initialCordinates,Orientation.EAST);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 2 || arr[1] == 1);
    }
    @Test
    public void testMoveForward_West(){
        int[] initialCordinates = {1,1};
        int[] arr = navigator.getNewPositionAfterMove(initialCordinates,Orientation.WEST);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 0 || arr[1] == 1);
    }

}
