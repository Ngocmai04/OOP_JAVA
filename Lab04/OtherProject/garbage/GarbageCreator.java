package Lab04.OtherProject.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "Lab03\\OtherProject\\garbage\\check.txt";
        String outputString = "";
        byte[] inputBytes = null;
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return; 
        }

        startTime = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputString += (char) b; 
        }
        endTime = System.currentTimeMillis();

        System.out.println("Thời gian sử dụng toán tử '+': " + (endTime - startTime) + " ms");
    }
}