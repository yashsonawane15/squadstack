package org.squadstack;

import org.squadstack.DAO.FileInput;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        String inputFileName = "input.txt";

        try{
            FileInput fileInput = new FileInput(inputFileName);
            String commandString = fileInput.next();
            ParkingLotController parkingLotController = new ParkingLotController();

            while(commandString != null) {
                if(commandString.length() == 0) {
                    commandString = fileInput.next();
                    continue;
                }

                String result = parkingLotController.executeCommand(commandString);
                if(result != null) {
                    System.out.println(result);
                }

                commandString = fileInput.next();
            }

        } catch(FileNotFoundException fnfe) {
            System.out.println("Trouble reading file");
            return;
        }


    }
}