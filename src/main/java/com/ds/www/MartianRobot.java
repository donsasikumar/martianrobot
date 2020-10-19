package com.ds.www;

import com.ds.www.helper.InputExtractor;
import com.ds.www.processor.LineProcessor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class MartianRobot {
    private static final Logger LOGGER = Logger.getLogger("MartianRobot.class");
    public static void main(String[] args) throws IOException {
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(System.in));
        LineProcessor lineProcessor = new LineProcessor();
        lineProcessor.processInputLines(lines);

    }
}

