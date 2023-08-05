package src.main.java.recursive;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAAAXZ";
        System.out.println(getLengthOfLongestCommonSubSequence(s1, s2, s1.length(), s2.length()));
    }

    private static int getLengthOfLongestCommonSubSequence(String s1, String s2, int s1Len, int s2Len) {
        if (s1Len == 0 || s2Len == 0) {
            return 0;
        }
        if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
            return 1 + getLengthOfLongestCommonSubSequence(s1, s2, s1Len - 1, s2Len - 1);
        } else {
            return Math.max(getLengthOfLongestCommonSubSequence(s1, s2, s1Len - 1, s2Len),
                    getLengthOfLongestCommonSubSequence(s1, s2, s1Len, s2Len - 1));
        }
    }
}
