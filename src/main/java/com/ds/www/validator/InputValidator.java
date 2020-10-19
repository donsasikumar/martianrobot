package com.ds.www.validator;

import com.ds.www.helper.InputExtractor;

import java.util.logging.Logger;

public class InputValidator {
    private static final Logger LOGGER = Logger.getLogger("InputValidator.class");


    public static boolean isInputValid(String[] lines){
        String[] maxCordinates = InputExtractor.getMaxCordinates(lines);
        String[] initialCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
        String[] instructions = InputExtractor.getInstructions(lines);
        if(!InputValidator.isInputLengthValid(lines) ||
                maxCordinates.length != 2 ||
                initialCordinates.length < 1  ||
                instructions.length <1 ||
                !InputValidator.isValidCordinates(maxCordinates)||
                !InputValidator.isInstructionLengthValid(instructions)) {
            return false;
        }
        return true;
    }

    static boolean isInputLengthValid(String[] lines) {
        return lines.length >= 3? true : false;
    }



    static boolean isValidCordinates(String[] cordinates) {
        boolean result = false;
        for (String s : cordinates) {
               if(s.equals(" ") && Integer.parseInt(s) > 50 ){
                return false;
            }
        }
        return true;
    }



     static boolean isInstructionLengthValid(String[] instructions) {
        int length = 0;
        for (String instruction : instructions) {
            length = instruction.length();
            LOGGER.info("Length of Instruction read is "+length);
            if(length >= 100) {
                return false;
            }else{
                continue;
            }

        }
        return true;
    }

}

