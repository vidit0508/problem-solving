package src.main.java.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutation {

    public static void main(String[] args) {
        String s = "aabbcadad";
        System.out.println(printAllPossiblePalindromes(s));
    }

    private static List<String> printAllPossiblePalindromes(String s) {
        List<String> res = new ArrayList<>();

        // calculate frequency of characters
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // now half the frequency
        // and also check is it actually feasible to make and palindrome
        // by keeping check on number of character with odd length
        Character oddChar = null;
        int oddCharCount = 0;
        int len = 0;

        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (freq % 2 != 0) {
                oddChar = c;
                oddCharCount++;
            }
            len = len + freq / 2;
            map.put(c, freq / 2);
        }

        if (oddCharCount > 1) {
            return res;
        }

        return generatePalindrome(1, len, oddChar, map, "", res);
    }

    private static List<String> generatePalindrome(int startPos, int len, Character oddChar, Map<Character, Integer> map,
                                            String resString, List<String> res) {
        if (startPos > len) {
            String rev = "";
            for (int i = resString.length() - 1; i >= 0; i--) {
                rev = rev + resString.charAt(i);
            }
            if (oddChar != null) {
                resString = resString + oddChar;
            }
            resString = resString + rev;
            res.add(resString);
            return res;
        }

        for (char c : map.keySet()) {
            int freq = map.get(c);
            if (freq > 0) {
                map.put(c, freq - 1);
                generatePalindrome(startPos + 1, len, oddChar, map, resString + c, res);
                map.put(c, freq);
            }
        }

        return res;
    }
}
