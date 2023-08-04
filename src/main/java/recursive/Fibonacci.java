package src.main.java.recursive;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(getFibonacci(5));
    }

    private static int getFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
}
