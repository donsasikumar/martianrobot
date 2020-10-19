package com.ds.www.helper;

import com.ds.www.domain.Move;
import com.ds.www.domain.Orientation;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


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

    @Test
    public void test_processInstruction_SampleInput1() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] instructions = InputExtractor.getInstructions(lines);
        String[] result = navigator.processInstruction(instructions[0],startCordinates[0].split(" "));
        System.out.println(result[0]);
        System.out.println(result[1]);
        assert result[0].equals("1");
        assert result[1].equals("1");
        assert result[2].equals("E");
    }

    @Test
    public void test_processInstruction_SampleInput2() throws IOException {
        String sampleInput = "5 3\n"
                + "3 2 N\n"
                + "FRRFLLFFRRFLL\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] instructions = InputExtractor.getInstructions(lines);
        String[] result = navigator.processInstruction(instructions[0],startCordinates[0].split(" "));
        System.out.println(result[0]);
        System.out.println(result[1]);
        assert result[0].equals("3");
        assert result[1].equals("3");
        assert result[2].equals("N");
    }

    @Test
    public void test_processInstruction_SampleInput3() throws IOException {
        String sampleInput = "5 3\n"
                + "0 3 W\n"
                + "LLFFFLFLFL\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] instructions = InputExtractor.getInstructions(lines);
        String[] result = navigator.processInstruction(instructions[0],startCordinates[0].split(" "));
        System.out.println(result[0]);
        System.out.println(result[1]);
        assert result[0].equals("2");
        assert result[1].equals("4");
        assert result[2].equals("S");
    }

    @Test
    public void test_processInstruction_SampleInput4() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                + "3 2 N\n"
                + "FRRFLLFFRRFLL\n"
                + "0 3 W\n"
                + "LLFFFLFLFL\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] instructions = InputExtractor.getInstructions(lines);
        for(int i =0 ;i< instructions.length ; i++){
            String[] result = navigator.processInstruction(instructions[i],startCordinates[i].split(" "));
            System.out.println(result[0]);
            System.out.println(result[1]);
            System.out.println(result[2]);
        }

    }
}
