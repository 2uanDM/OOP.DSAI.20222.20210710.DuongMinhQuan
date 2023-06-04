package hust.soict.dsai.garbage;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        String filename = "C:/Users/Thinkbook 14 G3 ACL/Documents/GitHub/OOP.DSAI.2022.2.20210710.DuongMinhQuan/AimsProjects/src/hust/soict/dsai/garbage/test.txt";
        long startTime, endTime;

        if (!Files.exists(Paths.get(filename))) {
            System.err.println("File not found: " + filename);
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filename), StandardCharsets.UTF_8)) {
            startTime = System.currentTimeMillis();
            StringBuilder outputStringBuilder = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                outputStringBuilder.append((char) c);
            }
            endTime = System.currentTimeMillis();
        }

        System.out.println("Time taken to read file and convert contents to StringBuilder: " + (endTime - startTime) + " milliseconds");
    }
}
