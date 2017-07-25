package ua.nure.chulkov.Practice3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    private static final String LOGIN_NAME_EMAIL_REGEX = "(.+);(.+);(.+@.+)";

    private static String convert1(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(LOGIN_NAME_EMAIL_REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            result.append(m.group(1)).append(" ==> ").append(m.group(3)).append("\n\r");
        }
        return result.toString();
    }

    private static String convert2(String input) {
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile(LOGIN_NAME_EMAIL_REGEX);
        Matcher m = p.matcher(input);
        while (m.find()) {
            result.append(m.group(2)).append(" (email: ").append(m.group(3)).append(")").append("\n\r");
        }
        return result.toString();
    }

    private static String convert3(String input) {
        List<String> logins = new ArrayList<>();
        Map<String, List<String>> domenLogin = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();
        Pattern p = Pattern.compile("(.+);(.+);(.+)@(.+)");
        Matcher m = p.matcher(input);

        fillMapByDomains(domenLogin, m);

        for (Map.Entry entry : domenLogin.entrySet()) {
            setLoginsWithCurrentDomain(logins, m, entry);
            domenLogin.put((String) entry.getKey(), logins);
            String loginsWithoutBracers = editViewOfLogins(entry);
            createResult(logins, result, entry, loginsWithoutBracers);
        }
        return result.toString();
    }

    private static void createResult(List<String> logins, StringBuilder sb, Map.Entry entry, String loginsWithoutBracers) {
        sb.append(entry.getKey())
                .append(" ==> ")
                .append(loginsWithoutBracers)
                .append("\r\n");
        logins.clear();
    }

    private static void setLoginsWithCurrentDomain(List<String> logins, Matcher m, Map.Entry entry) {
        while (m.find()) {
            if (entry.getKey().equals(m.group(4))){
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

    private static String convert4(String input) {
        StringBuilder result = new StringBuilder("Login;Name;Email;Passowrd\r\n");
        Pattern p = Pattern.compile("(.+;)(.+;)(.+@.+)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            String randomNumber = generateRandomNumber();
            result.append(m.group(1))
                    .append(m.group(2))
                    .append(m.group(3))
                    .append(";")
                    .append(randomNumber)
                    .append("\n\r");
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

    public static void main(String[] args) {
        System.out.println(Part1.convert1(Util.readFile("part1.txt")));
        System.out.println("----------------------------------------------");
        System.out.println(Part1.convert2(Util.readFile("part1.txt")));
        System.out.println("----------------------------------------------");
        System.out.println(Part1.convert3(Util.readFile("part1.txt")));
        System.out.println("----------------------------------------------");
        System.out.println(Part1.convert4(Util.readFile("part1.txt")));
        System.out.println("----------------------------------------------");
    }
}
