package ua.nure.chulkov.Practice3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Part1 {

    private static final String EOL = System.lineSeparator();

    private static final String LOGIN_NAME_EMAIL_REGEX = "([a-zA-Zà-ÿÀ-ß]+);" +
            "([a-zA-Zà-ÿÀ-ß]+\\s[a-zA-Zà-ÿÀ-ß]+)" +
            ";([a-zA-Zà-ÿÀ-ß]+@[a-zA-Zà-ÿÀ-ß]+\\S[a-zA-Zà-ÿÀ-ß]+)" +
            "(\\s+)?";

    private static final String LOGIN_NAME_EMAILNAME_DOMAIN_REGEX = "([a-zA-Zà-ÿÀ-ß]+);" +
            "([a-zA-Zà-ÿÀ-ß]+\\s[a-zA-Zà-ÿÀ-ß]+)" +
            ";([a-zA-Zà-ÿÀ-ß]+)" +
            "@([a-zA-Zà-ÿÀ-ß]+\\S[a-zA-Zà-ÿÀ-ß]+)" +
            "(\\s+)?";

    static String convert1(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(LOGIN_NAME_EMAIL_REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            result.append(m.group(1)).append(" ==> ").append(m.group(3));
            if (m.group(4) != null) {
                result.append(m.group(4));
            }
        }
        return result.toString();
    }

    static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(LOGIN_NAME_EMAIL_REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            result.append(m.group(2)).append(" (email: ").append(m.group(3)).append(")");
            if (m.group(4) != null) {
                result.append(m.group(4));
            }
        }
        return result.toString();
    }

    static String convert3(String input) {
        List<String> logins = new ArrayList<>();
        Map<String, List<String>> domenLogin = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(LOGIN_NAME_EMAILNAME_DOMAIN_REGEX);
        Matcher m = p.matcher(input);

        fillMapByDomains(domenLogin, m);

        for (Map.Entry entry : domenLogin.entrySet()) {
            setLoginsWithCurrentDomain(logins, m, entry);
            domenLogin.put((String) entry.getKey(), logins);
            String loginsWithoutBracers = editViewOfLogins(entry);
            createResult(logins, result, entry, domenLogin, loginsWithoutBracers);
        }
        return result.toString();
    }

    private static void createResult(List<String> logins, StringBuilder sb, Map.Entry entry, Map<String, List<String>> domenLogin, String loginsWithoutBracers) {
        sb.append(entry.getKey())
                .append(" ==> ")
                .append(loginsWithoutBracers);
        if (!entry.equals(domenLogin.entrySet().toArray()[domenLogin.size() - 1])) {
            sb.append(EOL);
        }
        logins.clear();
    }

    private static void setLoginsWithCurrentDomain(List<String> logins, Matcher m, Map.Entry entry) {
        while (m.find()) {
            if (entry.getKey().equals(m.group(4))) {
                logins.add(m.group(1));
            }
        }
        m.reset();
    }

    private static String editViewOfLogins(Map.Entry entry) {
        String loginsWithoutBracers = entry.getValue().toString();
        loginsWithoutBracers = loginsWithoutBracers.substring(1, loginsWithoutBracers.length() - 1);
        return loginsWithoutBracers;
    }

    private static void fillMapByDomains(Map<String, List<String>> domenLogin, Matcher m) {
        while (m.find()) {
            domenLogin.put(m.group(4), null);
        }
        m.reset();
    }

    static String convert4(String input) {
        StringBuilder result = new StringBuilder("Login;Name;Email;Password" + EOL);
        Pattern p = Pattern.compile(LOGIN_NAME_EMAIL_REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            String randomNumber = generateRandomNumber();
            result.append(m.group(1))
                    .append(";")
                    .append(m.group(2))
                    .append(";")
                    .append(m.group(3))
                    .append(";")
                    .append(randomNumber)
                    .append(EOL);
        }
        return result.toString();
    }

    private static String generateRandomNumber() {
        StringBuilder randomNumber = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int randomInt = r.nextInt(10);
            randomNumber.append(randomInt);
        }
        return randomNumber.toString();
    }
}
