package src.main.java.companywise.expedia;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(countSubstrings(s));
    }

    private static int countSubstrings(String s) {
        List<String> res = new ArrayList<>();

        // get all sub strings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String ss = s.substring(i, j);
                if (checkPalindrome(ss)) {
                    res.add(ss);
                }
            }
        }

        return res.size();
    }

    private static boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
