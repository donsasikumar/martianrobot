package com.ds.www.helper;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputExtractorTest {
    @Test
    public void test_readInputLines() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        assert  lines.length == 3;
        assert lines[0].equals("5 3");
        assert lines[1].equals("1 1 E");
        assert lines[2].equals("RFRFRFRF");
    }

    @Test
    public void test_getMaxCordinatesAsIntArray() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));

        int[] maxCordinates =  InputExtractor.getMaxCordinatesAsIntArray(lines);
        assert maxCordinates[0]==5;
        assert maxCordinates[1]==3;

    }

    @Test
    public void test_getMaxCordinates() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));

        String[] maxCordinates =  InputExtractor.getMaxCordinates(lines);
        assert maxCordinates[0].equals("5");
        assert maxCordinates[1].equals("3");

    }


    @Test
    public void test_getInitialCordinates() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                + "2 2 E\n"
                + "FFRR\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        assert startCordinates[0].equals("1 1 E");
        assert startCordinates[1].equals("2 2 E");
    }


    @Test
    public void test_getInitialOrientation() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                + "2 2 W\n"
                + "FFRR\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] initialOrientation = InputExtractor.getInitialOrientation(startCordinates);
        assert initialOrientation[0].equals("E");
        assert initialOrientation[1].equals("W");
    }

    @Test
    public void test_getInstructions() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                + "2 2 W\n"
                + "FFRR\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInstructions(lines);
        assert startCordinates[0].equals("RFRFRFRF");
        assert startCordinates[1].equals("FFRR");
    }

}
