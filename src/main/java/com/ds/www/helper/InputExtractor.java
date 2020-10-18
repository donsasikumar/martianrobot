package com.ds.www.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputExtractor {
    public static String[] readInputLines(InputStreamReader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        StringBuilder input = new StringBuilder();
        String str = "";
        while ((str = br.readLine()) != null) {
            input.append(str);
            input.append("\n");
        }
        return input.toString().split("\\n");
    }

    public static String[] getMaxCordinates(String[] lines) {
        return lines[0].split(" ");
    }

    public static String[] getInitialCordinates(String[] lines) {
        StringBuilder startCordinateLines = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if (i % 2 != 0) {
                startCordinateLines.append(lines[i].substring(0,lines[i].length()-2));
                startCordinateLines.append("\n");
            }
        }
        return startCordinateLines.toString().split("\\n");

    }

    public static String[] getInstructions(String[] lines) {
        StringBuilder instructionLines = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            if (i % 2 == 0) {
                instructionLines.append(lines[i]);
                instructionLines.append("\n");
            }
        }
        return instructionLines.toString().split("\\n");

    }
}
