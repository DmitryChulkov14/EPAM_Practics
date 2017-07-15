package ua.nure.chulkov.Practice1;

public class Part2 {
    public static void main(String[] args) {
        int first = Integer.valueOf(args[0]);
        int second = Integer.valueOf(args[1]);
        System.out.println(sum(first, second));
    }

    private static int sum(int first, int second){
        return first + second;
    }
}
