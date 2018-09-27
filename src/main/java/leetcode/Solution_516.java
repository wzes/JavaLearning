package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_516 {

    @Test
    public void Test() {
        Assert.assertEquals(4, longestPalindromeSubseq("abba"));
        Assert.assertEquals(2, longestPalindromeSubseq("abbc"));
    }

    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }

    int lcs(String s, String t) {
        int n = s.length();
        if (n <= 1) return n;
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[n][n];
    }
}
