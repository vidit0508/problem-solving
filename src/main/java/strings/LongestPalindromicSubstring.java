package src.main.java.strings;

public class LongestPalindromicSubstring {

    static int resultStart = 0;
    static int resultLength = 0;

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int start = 0; start < len - 1; start++) {
            expand(s, start, start);
            expand(s, start, start + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    public static void expand(String s, int begin, int end) {
        while (begin >= 0 && end < s.length()
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }
}
