package src.main.java.topicwise.strings;

public class StringToIntegerAtoi {

    public static void main(String[] args) {
        String s = " -4193 with words";
        System.out.println(myAtoi(s));
    }

    private static int myAtoi(String s) {
        int res = 0;
        boolean isNegative = false;
        if (s == null || s.trim().length() == 0) {
            return 0;
        }

        s = s.trim();
        if (s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1, s.length());
        } else if (s.charAt(0) == '+') {
            s = s.substring(1, s.length());
        }

        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);
            int val = ch - '0';
            if (val > 9 || val < 0) {
                break;
            }

            if ((res > Integer.MAX_VALUE / 10)
                    || (val > 7 && Integer.MAX_VALUE / 10 == res)) {
                if (isNegative) {
                    res = Integer.MIN_VALUE;
                } else {
                    res = Integer.MAX_VALUE;
                }
                break;
            }

            res = res * 10 + val;
            i++;
        }
        if (isNegative) {
            res = -1 * res;
        }
        return res;
    }
}
