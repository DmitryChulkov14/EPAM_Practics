package ua.nure.chulkov.Practice3;

public class Part5 {

    static final String[] ROME = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    static final int[] ARAB = {1, 4, 5, 9, 10, 40, 50, 90, 100};

    static String decimal2Roman(int x) {
        StringBuilder a = new StringBuilder();
        int c1 = x / 100;
        a.append(C(c1));

        int c2 = x % 100;
        int x1 = c2 / 10;
        a.append(X(x1));

        int x2 = c2 % 10;
        a.append(basic(x2));

        return a.toString();
    }

    private static String C(int in) {
        if ((in != 0) && (in < 4)) {
            StringBuilder a = new StringBuilder();
            appendRepeatNumbers(in, a, ROME[8]);
            return a.toString();
        } else return "";
    }

    private static void appendRepeatNumbers(int in, StringBuilder a, String str) {
        int i = 0;
        while (i < in) {
            a.append(str);
            i++;
        }
    }

    private static String X(int in) {
        if (in == 4) {
            return ROME[5];
        } else if (in == 9) {
            return ROME[7];
        } else if (in > 4) {
            return ROME[6];
        } else if (in != 0) {
            StringBuilder a = new StringBuilder();
            appendRepeatNumbers(in, a, ROME[4]);
            return a.toString();
        } else return "";
    }

    private static String basic(int in) {
        String[] a = {
                "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
        };
        return a[in];
    }

    static int roman2Decimal(String s) {
        StringBuilder romeNumber = new StringBuilder(s);
        int arabNumber = 0;
        while (romeNumber.length() > 0) {
            StringBuilder tempRomeNumber = new StringBuilder(romeNumber);
            for (int i = 0; i < romeNumber.length(); i++) {
                for (int j = 0; j < ROME.length; j++) {
                    if (ROME[j].equals(tempRomeNumber.toString())) {
                        arabNumber += ARAB[j];
                        romeNumber.delete(0, ROME[j].length());
                        break;
                    }
                }
                tempRomeNumber.deleteCharAt(tempRomeNumber.length() - 1);
            }
        }
        return arabNumber;
    }

    public static void main(String[] args) {
        for (int arabicNum = 1; arabicNum <= 100; arabicNum++) {
            String romanNum = decimal2Roman(arabicNum);
            System.out.println(arabicNum + " ====> " + romanNum + " ====> " + roman2Decimal(romanNum));
        }
    }
}
