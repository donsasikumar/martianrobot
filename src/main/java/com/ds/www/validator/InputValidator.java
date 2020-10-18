package com.ds.www.validator;

import java.io.*;
import java.util.logging.Logger;

public class InputValidator {
    private static final Logger LOGGER = Logger.getLogger("InputValidator.class");


    static boolean isInputValid(String[] lines) {
        return lines.length >= 3 ? true : false;
    }



    static boolean isValidCordinates(String[] cordinates) {
        for (String s : cordinates) {
            return Integer.parseInt(s) > 50 ? false : true;
        }
        return false;
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

