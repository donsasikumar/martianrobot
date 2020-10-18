package com.ds.www.validator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PositionValidatorTest {

    PositionValidator positionValidator = new PositionValidator();

    @Test
    public void test_isOnGrid(){
        assert positionValidator.isOnGrid(0,0,0,0);
        assert !positionValidator.isOnGrid(5,5,5,1);
        assert !positionValidator.isOnGrid(-1,0,0,0);
        assert !positionValidator.isOnGrid(1,2,1,1);

    }

    @Test
    public void test_isLostPosition(){
        List<String> lostPositions = new ArrayList<>();
        lostPositions.add("50");
        lostPositions.add("51");
        lostPositions.add("52");
        lostPositions.add("53");
        assert positionValidator.isLostPosition(5,0,lostPositions);
        assert positionValidator.isLostPosition(5,1,lostPositions);
        assert positionValidator.isLostPosition(5,2,lostPositions);
        assert positionValidator.isLostPosition(5,3,lostPositions);
        assert !positionValidator.isLostPosition(5,4,lostPositions);
    }
}
