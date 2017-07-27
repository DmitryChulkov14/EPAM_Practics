package ua.nure.chulkov.Practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Part3 {

    private static final String REGEX = "\\S?[a-zA-Zà-ÿÀ-ß]+\\W?+\\s?+";
    private static final String REGEXMORETHREE = "\\S?[a-zA-Zà-ÿÀ-ß]{3,}\\W?+\\s?+";

    static String convert(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            String curWord = m.group();
            if (curWord.matches(REGEXMORETHREE)){
                curWord = curWord.substring(0, 1).toUpperCase() + curWord.substring(1);
            }
            result.append(curWord);
        }
        return result.toString();
    }
}
