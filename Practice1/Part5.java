package ua.nure.chulkov.Practice1;

public class Part5 {
    public static void main(String[] args) {
        int digit1 = Integer.parseInt(args[0]);
        String char1 = String.valueOf(args[1]);
        String char2 = String.valueOf(args[2]);
        System.out.println(char1 + " --> " + Part5.chars2digits(char1));
        System.out.println(digit1 + " --> " + Part5.digits2chars(digit1));
        System.out.println(char2 + " --> " + Part5.rightColumn(char2));
    }

    public static int chars2digits(String number) {
        int sum = 0;
        char[] chars = number.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int curNum = chars[chars.length - 1 - i] - ('A' - 1);
            sum += curNum * Math.pow(26, i);
        }
        return sum;
    }

    public static String digits2chars(int number) {
        StringBuilder chars = new StringBuilder();
        StringBuilder charsMirror = new StringBuilder();
        int modulo;
        int dividend = number;
        while (dividend != 0) {
            modulo = dividend % 26;
            if (modulo == 0) {
                chars.append('Z');
                dividend = (dividend - 1) / 26;
            } else {
                chars.append((char)(modulo + ('A' - 1)));
                dividend = (dividend - modulo) / 26;
            }
        }
        for (int i = 0; i < chars.length(); i++){
            charsMirror.append(chars.charAt(chars.length() - i - 1));
        }
        return charsMirror.toString();
    }

    public static String rightColumn(String number) {
        String chars;
        int num;
        num = chars2digits(number);
        num++;
        chars = digits2chars(num);
        return chars;
    }
}
