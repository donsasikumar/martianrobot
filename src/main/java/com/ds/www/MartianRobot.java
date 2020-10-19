package com.ds.www;

import com.ds.www.helper.InputExtractor;
import com.ds.www.helper.Navigator;
import com.ds.www.validator.InputValidator;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class MartianRobot {
    private static final Logger LOGGER = Logger.getLogger("MartianRobot.class");
    public static void main(String[] args) throws IOException {
        String[] lines = InputExtractor.readInputLines(new InputStreamReader(System.in));
        for(String s:lines) {
            LOGGER.info(s);
        }
    if(InputValidator.isInputValid(lines)){
        Navigator navigator = new Navigator();
        String[] initialCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] instructions = InputExtractor.getInstructions(lines);
        for(int i =0; i<initialCordinates.length; i++){
            String[] initialPosition = initialCordinates[i].split(" ");
            navigator.processInstruction(instructions[i],initialPosition);
        }
    }else{
        LOGGER.info("INVALID INPUT");
        System.exit(0);
    }

    }
}

