package com.ds.www;


import com.ds.www.domain.Orientation;
import org.junit.Test;

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


}
