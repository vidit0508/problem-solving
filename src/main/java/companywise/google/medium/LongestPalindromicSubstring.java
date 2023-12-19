package src.main.java.companywise.google.medium;

public class LongestPalindromicSubstring {

    int resultStart = 0;
    int resultLength = 0;

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }

        return s.substring(resultStart, resultStart + resultLength);
    }

    public void expand(String s, int begin, int end) {
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
