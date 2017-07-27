package ua.nure.chulkov.Practice3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Part2 {

    private static final String EOL = System.lineSeparator();

    private static final String REGEX = "[a-zA-Zà-ÿÀ-ß]+";

    static String convert(String input) {
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

        result.append("Min: ").append(minLengthWords).append(EOL)
                .append("Max: ").append(maxLengthWords);

        return result.toString();
    }

    private static int getMaxLength(int maxLength, Map.Entry word) {
        int max = maxLength;
        if ((Integer) word.getValue() > maxLength) {
            max = (int) word.getValue();
        }
        return max;
    }

    private static int getMinLength(int minLength, Map.Entry word) {
        int min = minLength;
        if ((Integer) word.getValue() < minLength) {
            min = (int) word.getValue();
        }
        return min;
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
}
