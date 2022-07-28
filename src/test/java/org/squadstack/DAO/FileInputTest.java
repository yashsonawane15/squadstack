package org.squadstack.DAO;


import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FileInputTest {

    @Test
    public void testNextMethod() {
        List<String> words = new ArrayList<String>(List.of( "one", "two", "three" ));
        String testFile = "src/main/resources/tests/test-file.txt";
        int wordsPtr = 0;
        int wordsCount = 0;

        try {
            FileInput fileInput = new FileInput(testFile);

            String inputLine = fileInput.next();

            while(inputLine != null) {
                assertEquals(inputLine, words.get(wordsPtr));
                ++wordsCount;
                inputLine = fileInput.next();
                ++wordsPtr;
            }

            assertEquals(wordsCount, words.size());

        } catch(FileNotFoundException fnfe) {
            System.out.println("Test file not found");
            fail();
        }
    }


}