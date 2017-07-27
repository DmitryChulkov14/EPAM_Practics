package ua.nure.chulkov.Practice3;

class Part5 {

    private static final String[] ROME = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    private static final int[] ARAB = {1, 4, 5, 9, 10, 40, 50, 90, 100};

    static String decimal2Roman(int x) {
        StringBuilder result = new StringBuilder();
        int c1 = x / 100;
        result.append(getHundreds(c1));

        int c2 = x % 100;
        int x1 = c2 / 10;
        result.append(getDozens(x1));

        int x2 = c2 % 10;
        result.append(getOnes(x2));

        return result.toString();
    }

    private static String getHundreds(int in) {
        if ((in != 0) && (in < 4)) {
            StringBuilder result = new StringBuilder();
            appendRepeatNumbers(in, result, ROME[8]);
            return result.toString();
        } else {
            return "";
        }
    }

    private static void appendRepeatNumbers(int in, StringBuilder result, String str) {
        int i = 0;
        while (i < in) {
            result.append(str);
            i++;
        }
    }

    private static String getDozens(int in) {
        int curIn = in;
        StringBuilder result = new StringBuilder();
        while (curIn > 0) {
            if (curIn == 4) {
                result.append(ROME[5]);
                curIn -= 4;
            } else if (curIn == 9) {
                result.append(ROME[7]);
                curIn -= 9;
            } else if (curIn > 4) {
                result.append(ROME[6]);
                curIn -= 5;
            } else {
                result.append(ROME[4]);
                curIn -= 1;
            }
        }
        return result.toString();
    }

    private static String getOnes(int in) {
        String[] ones = {
                "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
        };
        return ones[in];
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
}
