package ua.nure.chulkov.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    private static final String REGEX = "\\S?[a-zA-Zа-яА-Я]+\\W?+\\s?+";
    private static final String REGEXMORETHREE = "\\S?[a-zA-Zа-яА-Я]{3,}\\W?+\\s?+";

    static String convert(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            String curWord = m.group();
            if (curWord.matches(REGEXMORETHREE)){
                curWord = curWord.replace(curWord.substring(0, 1), curWord.substring(0, 1).toUpperCase());
            }
            result.append(curWord);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Part3.convert(Util.readFile("part3.txt")));
    }
}
