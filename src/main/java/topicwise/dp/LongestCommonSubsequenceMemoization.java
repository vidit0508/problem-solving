package src.main.java.topicwise.dp;

public class LongestCommonSubsequenceMemoization {

    static int[][] dp = null;
    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAAAXZ";
        dp = new int[s1.length() + 1][s2.length() + 1];

        for (int[] row : dp) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -1;
            }
        }

        System.out.println(getLengthOfLCSByMemoization(s1, s2, s1.length(), s2.length()));

    }

    private static int getLengthOfLCSByMemoization(String s1, String s2, int s1Len, int s2Len) {
        if (s1Len == 0 || s2Len == 0) {
            return 0;
        }

        if (dp[s1Len - 1][s2Len - 1] != -1) {
            return dp[s1Len - 1][s2Len - 1];
        }

        if (s1.charAt(s1Len - 1) == s2.charAt(s2Len - 1)) {
            dp[s1Len - 1][s2Len - 1] = 1 + getLengthOfLCSByMemoization(s1, s2, s1Len - 1, s2Len - 1);
        } else {
            dp[s1Len - 1][s2Len - 1] = Math.max(getLengthOfLCSByMemoization(s1, s2, s1Len, s2Len - 1),
                    getLengthOfLCSByMemoization(s1, s2, s1Len - 1, s2Len));
        }
        return dp[s1Len - 1][s2Len - 1];
    }
}
