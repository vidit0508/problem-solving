package src.main.java.dp;

public class EditDistanceTabulation {

    static int[][] dp = null;

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        int s1Len = s1.length();
        int s2Len = s2.length();
        System.out.println(getMinimumEdits(s1, s2, s1Len, s2Len));
    }

    private static int getMinimumEdits(String s1, String s2, int s1Len, int s2Len) {

        dp = new int[s1Len + 1][s2Len + 1];

        for (int i = 0; i <= s1Len; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= s2Len; i++) {
            dp[0][i] = i;
        }

        for (int row = 1; row <= s1Len; row++) {
            for (int col = 1; col <= s2Len; col++) {
                char s1Char = s1.charAt(row - 1);
                char s2Char = s2.charAt(col - 1);
                if (s1Char == s2Char) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    dp[row][col] = 1 + Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]);
                }
            }
        }
        return dp[s1Len][s2Len];
    }
}
