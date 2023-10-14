package src.main.java.topicwise.dp;

public class LongestCommonSubsequenceTabulation {

    static int[][] dp = null;
    public static void main(String[] args) {
        String s1 = "AXYZ";
        String s2 = "BAAAXZ";
        dp = new int[s1.length() + 1][s2.length() + 1];

        System.out.println(getLengthOfLCSByTabulation(s1, s2, s1.length(), s2.length()));

    }

    private static int getLengthOfLCSByTabulation(String s1, String s2, int s1Len, int s2Len) {
        dp = new int[s1Len + 1][s2Len + 1];

        // since first row and first column is always zero value, as
        // there either s1 or s2 will be empty

        for (int row = 1; row <= s1Len; row++) {
            for (int col = 1; col <= s2Len; col++) {
                if (s1.charAt(row - 1) == s2.charAt(col - 1)) {
                    dp[row][col] = 1 + dp[row - 1][col - 1];
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        return dp[s1Len][s2Len];
    }
}
