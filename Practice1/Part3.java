package ua.nure.chulkov.Practice1;

public class Part3 {
    public static void main(String[] args) {
        int number1 = Integer.valueOf(args[0]);
        int number2 = Integer.valueOf(args[1]);
        System.out.println(getNODofTwoNumbers(number1, number2));
    }

    private static int getNODofTwoNumbers(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        return num1;
    }
}
