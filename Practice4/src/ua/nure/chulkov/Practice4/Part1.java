package ua.nure.chulkov.Practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String FILE_NAME = "part1.txt";
    private static final String ENCODING = "Cp1251";
    private static final String REGEX = "\\S?[a-zA-Zа-яА-Я]+\\W?+\\s?+";
    private static final String REGEXMORETHREE = "\\S?[a-zA-Zа-яА-Я]{4,}\\W?+\\s?+";

    static String convert(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            String curWord = m.group();
            if (curWord.matches(REGEXMORETHREE)) {
                curWord = curWord.replace(curWord, curWord.toUpperCase());
            }
            result.append(curWord);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert(Util.readFile(FILE_NAME, ENCODING)));
    }

}