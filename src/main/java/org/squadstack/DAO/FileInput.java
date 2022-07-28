package org.squadstack.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;


public class FileInput implements Iterator {

    BufferedReader bufferedReader;

    public FileInput(String filePath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(filePath);
        bufferedReader = new BufferedReader(fileReader);
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
