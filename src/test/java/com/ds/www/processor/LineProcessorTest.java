package com.ds.www.processor;

import com.ds.www.helper.InputExtractor;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LineProcessorTest {
    LineProcessor processor = new LineProcessor();
    @Test
    public void test_processInstruction_SampleInput1() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] instructions = InputExtractor.getInstructions(lines);
        int[] maxCordindates = InputExtractor.getMaxCordinatesAsIntArray(lines);
        String result = processor.processInstruction(maxCordindates,startCordinates[0].split(" "),instructions[0]);
        assert result.equals("1 1 E");
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
        int[] maxCordindates = InputExtractor.getMaxCordinatesAsIntArray(lines);
        String result = processor.processInstruction(maxCordindates,startCordinates[0].split(" "),instructions[0]);
        assert result.equals("3 3 N LOST");
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
        int[] maxCordindates = InputExtractor.getMaxCordinatesAsIntArray(lines);
        String result = processor.processInstruction(maxCordindates,startCordinates[0].split(" "),instructions[0]);
        assert result.equals("2 4 S LOST");

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
        List<String> results = processor.processInputLines(lines);
        assert results.get(0).equals("1 1 E");
        assert results.get(1).equals("3 3 N LOST");
        assert results.get(2).equals("2 4 S LOST");

    }
}
