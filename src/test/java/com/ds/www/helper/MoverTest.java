package com.ds.www.helper;


import com.ds.www.domain.Orientation;
import org.junit.Test;

import java.util.Arrays;

public class MoverTest {

    Mover mover = new Mover();

    @Test
    public void testMoveRight() {
        assert mover.moveRight(Orientation.NORTH).equals(Orientation.EAST);
        assert mover.moveRight(Orientation.SOUTH).equals(Orientation.WEST);
        assert mover.moveRight(Orientation.EAST).equals(Orientation.SOUTH);
        assert mover.moveRight(Orientation.WEST).equals(Orientation.NORTH);
    }

    @Test
    public void testMoveLeft() {
        assert mover.moveLeft(Orientation.NORTH).equals(Orientation.WEST);
        assert mover.moveLeft(Orientation.SOUTH).equals(Orientation.EAST);
        assert mover.moveLeft(Orientation.EAST).equals(Orientation.NORTH);
        assert mover.moveLeft(Orientation.WEST).equals(Orientation.SOUTH);
    }

    @Test
    public void testMoveForward_North(){
        int[] arr = mover.moveForward(1,1,Orientation.NORTH);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 1 || arr[1] == 2);
    }
    @Test
    public void testMoveForward_South(){
        int[] arr = mover.moveForward(1,1,Orientation.SOUTH);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 1 || arr[1] == 0);
    }

    @Test
    public void testMoveForward_East(){
        int[] arr = mover.moveForward(1,1,Orientation.EAST);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 2 || arr[1] == 1);
    }
    @Test
    public void testMoveForward_West(){
        int[] arr = mover.moveForward(1,1,Orientation.WEST);
        assert arr.length==2;
        assert Arrays.stream(arr).anyMatch(i -> arr[0] == 0 || arr[1] == 1);
    }


}
