package org.squadstack;

import org.squadstack.DAO.FileInput;

import java.io.FileNotFoundException;

public class Main {
    ParkingLotController parkingLot;
    public static void main(String[] args) {

        String inputFileName = "";

        try{
            FileInput fileInput = new FileInput(inputFileName);

            String command = fileInput.next();

            while(command != null) {

            }

        } catch(FileNotFoundException fnfe) {
            System.out.println("Trouble reading file");
            return;
        }


    }
}