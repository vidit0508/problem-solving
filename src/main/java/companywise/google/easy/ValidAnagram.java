package src.main.java.companywise.google.easy;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if ((s == null && t != null)
                || (s != null && t == null)
                || (s.trim().length() != t.trim().length())) {
            return false;
        }

        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
            chars[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
