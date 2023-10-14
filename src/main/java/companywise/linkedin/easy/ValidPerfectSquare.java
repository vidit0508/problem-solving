package src.main.java.companywise.linkedin.easy;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }

    public static boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }

        for (int i = 1; i * i >= 0 && i * i <= num; i ++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
