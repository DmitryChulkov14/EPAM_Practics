package ua.nure.chulkov.Practice4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Part2 {

    private static final String RAW_DATA = "part2.txt";

    private static final String SORTED_DATA = "part2_sorted.txt";

    private static final int MAX = 50;

    public static void main(String[] args) throws IOException {
        String _10RandomNumbers = generate10RandomNumbers();
        System.out.println("input ==> " + _10RandomNumbers);

        writeNumbersToFile(Paths.get(RAW_DATA), _10RandomNumbers);

        String randomNumbersFromFile = readNumbersFromFile(RAW_DATA);
        String sortedNumbersFromFile = sortNumbers(randomNumbersFromFile);

        System.out.println("output ==> " + sortedNumbersFromFile);
        writeNumbersToFile(Paths.get(SORTED_DATA), sortedNumbersFromFile);
    }

    private static int generateRandomNumbers(int maxValue) {
        Random r = new Random();
        return r.nextInt(maxValue + 1);
    }

    private static String generate10RandomNumbers() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuilder
                    .append(generateRandomNumbers(MAX))
                    .append(" ");
        }

        return stringBuilder.toString();
    }

    private static void writeNumbersToFile(Path path, String numbers) throws IOException {
        Files.write(
                path,
                numbers.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
    }

    private static String readNumbersFromFile(String path) {
        return Util.readFile(path, "Cp1251");
    }

    private static String sortNumbers(String numbers) {
        List<String> numbersList = new ArrayList<>(Arrays.asList(numbers.split(" ")));

        List<Integer> numbersInInt = numbersList.stream().map(Integer::parseInt).collect(Collectors.toList());
        bubbleSort(numbersInInt);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbersInInt) {
            stringBuilder
                    .append(number)
                    .append(" ");
        }

        return stringBuilder.toString();
    }

    private static void bubbleSort(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
    }
}