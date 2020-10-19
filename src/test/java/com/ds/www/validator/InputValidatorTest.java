package com.ds.www.validator;

import com.ds.www.helper.InputExtractor;
import org.junit.Test;

import java.io.*;

public class InputValidatorTest {

    @Test
    public void test_isInputValid() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        assert InputValidator.isInputValid(lines);

    }

    @Test
    public void test_isValidCordinates() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] maxCordinates =  InputExtractor.getMaxCordinates(lines);
        String[] startCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);

        assert InputValidator.isValidCordinates(maxCordinates);
        for(String s : startCordinates){
            InputValidator.isValidCordinates(s.split(" "));
        }
    }

    @Test
    public void test_getInstructions() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                + "2 2 E\n"
                + "FFRR\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] instructions = InputExtractor.getInstructions(lines);
        assert instructions[0].equals("RFRFRFRF");
        assert instructions[1].equals("FFRR");
    }

    @Test
    public void test_isValidInstruction() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                + "2 2 E\n"
                + "FFRR\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] instructions = InputExtractor.getInstructions(lines);
        assert instructions.length == 2;
        assert InputValidator.isInstructionLengthValid(instructions);
    }

    @Test
    public void test_isValidInstruction_Returns_False_TooLong_Instruction() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF\n"
                + "2 2 E\n"
                + "FFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRRFFRF\n"
                +"exit";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] instructions = InputExtractor.getInstructions(lines);
        assert !InputValidator.isInstructionLengthValid(instructions);
    }
}
