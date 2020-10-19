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




}
