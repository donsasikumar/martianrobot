package com.ds.www.helper;

import com.ds.www.validator.InputValidator;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputExtractorTest {
    @Test
    public void test_readInputLines() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        assert  lines.length == 3;
        assert lines[0].equals("5 3");
        assert lines[1].equals("1 1 E");
        assert lines[2].equals("RFRFRFRF");
    }

    @Test
    public void test_getMaxCordinates() throws IOException {
        String sampleInput = "5 3\n"
                + "1 1 E\n"
                + "RFRFRFRF";
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
                + "FFRR";
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(new ByteArrayInputStream(sampleInput.getBytes())));
        String[] startCordinates = InputExtractor.getInitialCordinates(lines);
        assert startCordinates[0].equals("1 1");
        assert startCordinates[1].equals("2 2");
    }

}
