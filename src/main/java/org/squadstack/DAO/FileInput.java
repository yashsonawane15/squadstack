package org.squadstack.DAO;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;


public class FileInput {

    BufferedReader bufferedReader;

    public FileInput(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);
    }

    public String next() {
        try {
            return bufferedReader.readLine();
        } catch(IOException ioe) {
            return null;
        }
    }
}
