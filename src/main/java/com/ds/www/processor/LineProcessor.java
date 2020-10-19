package com.ds.www.processor;

import com.ds.www.domain.Move;
import com.ds.www.domain.Orientation;
import com.ds.www.exception.InvalidInputException;
import com.ds.www.helper.InputExtractor;
import com.ds.www.helper.Navigator;
import com.ds.www.validator.InputValidator;
import com.ds.www.validator.PositionValidator;

import java.util.ArrayList;
import java.util.List;

public class LineProcessor implements Processor{

    public List<String> processInputLines(String[] lines) {
        List<String> results = new ArrayList<>();
        if (InputValidator.isInputValid(lines)) {
            Navigator navigator = new Navigator();
            int[] maxCorindates = InputExtractor.getMaxCordinatesAsIntArray(lines);
            String[] initialCordinates = InputExtractor.getInitialCordinatesAndOrientation(lines);
            String[] instructions = InputExtractor.getInstructions(lines);
            for (int i = 0; i < initialCordinates.length; i++) {
                String[] initialPosition = initialCordinates[i].split(" ");
                results.add(processInstruction(maxCorindates, initialPosition, instructions[i]).toString());
            }
        } else {
            throw new InvalidInputException("INVALID INPUT");
        }
        return results;
    }
    String processInstruction(int[] maxCorindates, String[] initialPosition, String instruction) {
        int[] currentPosition = new int[]{Integer.parseInt(initialPosition[0]), Integer.parseInt(initialPosition[1])};
        Orientation currentOrientation = Navigator.getOrientation(initialPosition[2]);
        int[] newPosition = null;
        boolean isLost = false;
        List<String> lostPositions = new ArrayList<>();
        for (int i = 0; i < instruction.length(); i++) {
            Move nextMove = Navigator.navigate(instruction.charAt(i));
            Orientation orientationForThisMove = Navigator.findOrientation(nextMove, currentOrientation);
            currentOrientation = orientationForThisMove;
            if (nextMove == Move.FORWARD) {
                newPosition = Navigator.getNewPositionAfterMove(currentPosition, orientationForThisMove);
                currentPosition = newPosition;
                if (PositionValidator.isLostPosition(currentPosition[0], currentPosition[1], lostPositions)) {
                    isLost = true;
                }
                else if (!PositionValidator.isOnGrid(currentPosition[0], currentPosition[1], maxCorindates[0], maxCorindates[1])) {
                    lostPositions.add(currentPosition[0] + " " + currentPosition[1]);
                    isLost = true;
                }
            }
        }
        String output = null;
        if(!isLost) {
            output = ""+newPosition[0]+" "+ newPosition[1]+" "+ Navigator.getOrientationString(currentOrientation);
            System.out.println(output);
        }else{
            output = ""+newPosition[0]+" "+ newPosition[1]+" "+ Navigator.getOrientationString(currentOrientation)+" "+"LOST";
            System.out.println(output);
        }

        return output;
    }


}
