package ua.nure.chulkov.Practice4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class Part2 {

    private static final String RAW_DATA = "part2.txt";

    private static final String SORTED_DATA = "part2_sorted.txt";

    private static final int MAX = 50;

    private static void writeNumbersToFile() throws IOException {

    }

    private static String readNumbersFromFile(){
        return null;
    }

    private static int generateRandomNumbers(int maxValue) {
        Random r = new Random();
        return r.nextInt(maxValue + 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(generateRandomNumbers(MAX) + " ");
        }
    }

}