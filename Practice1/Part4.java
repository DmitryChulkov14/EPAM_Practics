package ua.nure.chulkov.Practice1;

public class Part4 {
    public static void main(String[] args) {
        int curNumber = Integer.valueOf(args[0]);
        System.out.println(countSumOfDigits(curNumber));
    }

    private static int countSumOfDigits(int inputNumber){
        int sum = 0;
        while (inputNumber > 0){
            int temp = inputNumber % 10;
            sum += temp;
            inputNumber /= 10;
        }
        return sum;
    }
}
