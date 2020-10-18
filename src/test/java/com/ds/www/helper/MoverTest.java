package com.ds.www.helper;


import com.ds.www.domain.Orientation;
import org.junit.Test;

import java.util.Arrays;

public class MoverTest {

    @Test
    public void testMoveRight() {
        assert Mover.moveRight(Orientation.NORTH).equals(Orientation.EAST);
        assert Mover.moveRight(Orientation.SOUTH).equals(Orientation.WEST);
        assert Mover.moveRight(Orientation.EAST).equals(Orientation.SOUTH);
        assert Mover.moveRight(Orientation.WEST).equals(Orientation.NORTH);
    }

    @Test
    public void testMoveLeft() {
        assert Mover.moveLeft(Orientation.NORTH).equals(Orientation.WEST);
        assert Mover.moveLeft(Orientation.SOUTH).equals(Orientation.EAST);
        assert Mover.moveLeft(Orientation.EAST).equals(Orientation.NORTH);
        assert Mover.moveLeft(Orientation.WEST).equals(Orientation.SOUTH);
    }

    @Test
    public void testMoveForward_North(){
        int[] arr = Mover.moveForwardWithCordinates(1,1,Orientation.NORTH);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 1 || arr[1] == 2);
    }
    @Test
    public void testMoveForward_South(){
        int[] arr = Mover.moveForwardWithCordinates(1,1,Orientation.SOUTH);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 1 || arr[1] == 0);
    }

    @Test
    public void testMoveForward_East(){
        int[] arr = Mover.moveForwardWithCordinates(1,1,Orientation.EAST);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 2 || arr[1] == 1);
    }
    @Test
    public void testMoveForward_West(){
        int[] arr = Mover.moveForwardWithCordinates(1,1,Orientation.WEST);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 0 || arr[1] == 1);
    }


}
