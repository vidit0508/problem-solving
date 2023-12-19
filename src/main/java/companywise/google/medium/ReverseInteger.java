package src.main.java.companywise.google.medium;

public class ReverseInteger {

    public int reverse(int x) {
        int rev = 0;
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x = -1 * x;
        }

        while (x > 0) {
            int val = x % 10;
            if ((rev > Integer.MAX_VALUE / 10)
                    || (rev == Integer.MAX_VALUE / 10 && x > 7)) {
                rev = 0;
                break;
            }
            rev = rev * 10 + val;
            x = x / 10;
        }
        if (isNegative) {
            rev = -1 * rev;
        }
        return rev;
    }
}
