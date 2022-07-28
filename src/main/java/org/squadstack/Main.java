package org.squadstack;

import org.squadstack.DAO.FileInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    ParkingLot parkingLot;
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