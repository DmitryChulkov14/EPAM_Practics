package ua.nure.chulkov.Practice3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    private static final String REGEX = "[a-zA-Zа-яА-Я]+";

    private static String convert(String input) {
        Map<String, Integer> words = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            words.put(m.group(), m.group().length());
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        for (Map.Entry word : words.entrySet()) {
            minLength = getMinLength(minLength, word);
            maxLength = getMaxLength(maxLength, word);
        }

        List<String> minLengthWordsList = new ArrayList<>();
        List<String> maxLengthWordsList = new ArrayList<>();
        for (Map.Entry word : words.entrySet()) {
            fillListWithWordsByNeededLength(minLength, minLengthWordsList, word);
            fillListWithWordsByNeededLength(maxLength, maxLengthWordsList, word);
        }

        String minLengthWords = getCorrectStringViewFromListOfWords(minLengthWordsList);
        String maxLengthWords = getCorrectStringViewFromListOfWords(maxLengthWordsList);

        result.append("Min: ").append(minLengthWords).append("\r\n")
                .append("Max: ").append(maxLengthWords);

        return result.toString();
    }

    private static int getMaxLength(int maxLength, Map.Entry word) {
        if ((Integer) word.getValue() > maxLength) {
            maxLength = (int) word.getValue();
        }
        return maxLength;
    }

    private static int getMinLength(int minLength, Map.Entry word) {
        if ((Integer) word.getValue() < minLength) {
            minLength = (int) word.getValue();
        }
        return minLength;
    }

    private static String getCorrectStringViewFromListOfWords(List<String> minLengthWordsList) {
        String minLengthWords = minLengthWordsList.toString();
        minLengthWords = minLengthWords.substring(1, minLengthWords.length() - 1);
        return minLengthWords;
    }

    private static void fillListWithWordsByNeededLength(int minLength, List<String> minLengthWords, Map.Entry word) {
        if ((int) word.getValue() == minLength){
            minLengthWords.add(word.getKey().toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(Part2.convert(Util.readFile("part2.txt")));
    }
}
