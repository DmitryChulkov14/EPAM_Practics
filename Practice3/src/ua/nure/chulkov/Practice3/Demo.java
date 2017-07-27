package ua.nure.chulkov.Practice3;

import java.security.NoSuchAlgorithmException;

public class Demo {

    private static final String PART1 = "part1.txt";
    private static final String PART2 = "part2.txt";
    private static final String PART3 = "part3.txt";
    private static final String SEPARATOR = "part3.txt";
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("-------------------Part1----------------------");
        System.out.println(Part1.convert1(Util.readFile(PART1)));
        System.out.println(SEPARATOR);
        System.out.println(Part1.convert2(Util.readFile(PART1)));
        System.out.println(SEPARATOR);
        System.out.println(Part1.convert3(Util.readFile(PART1)));
        System.out.println(SEPARATOR);
        System.out.println(Part1.convert4(Util.readFile(PART1)));
        System.out.println(SEPARATOR);
        System.out.println("-------------------Part2----------------------");
        System.out.println(Part2.convert(Util.readFile(PART2)));
        System.out.println(SEPARATOR);
        System.out.println("-------------------Part3----------------------");
        System.out.println(Part3.convert(Util.readFile(PART3)));
        System.out.println(SEPARATOR);
        System.out.println("-------------------Part4----------------------");
        System.out.println(Part4.hash("adf", "MD5"));
        System.out.println(Part4.hash("passwort", "SHA-256"));
        System.out.println(SEPARATOR);
        System.out.println("-------------------Part5----------------------");
        for (int arabicNum = 1; arabicNum <= 100; arabicNum++) {
            String romanNum = Part5.decimal2Roman(arabicNum);
            System.out.println(arabicNum + " ====> " + romanNum + " ====> " + Part5.roman2Decimal(romanNum));
        }
    }
}
