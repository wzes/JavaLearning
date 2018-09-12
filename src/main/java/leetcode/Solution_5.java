package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 8/28/18
 */
public class Solution_5 {
    @Test
    public void Test() {
        Assert.assertEquals("aba", longestPalindrome("babad"));
        Assert.assertEquals("babab", longestPalindrome("babab"));
        Assert.assertEquals("aa", longestPalindrome("bbaa"));
        Assert.assertEquals("ddd", longestPalindrome("bbccddd"));
        Assert.assertEquals("bbb", longestPalindrome("bbbccdd"));
        Assert.assertEquals("b", longestPalindrome("b"));
        Assert.assertEquals("bb", longestPalindrome("abb"));
        Assert.assertEquals("bb", longestPalindrome("bb"));
        Assert.assertEquals("aaaa", longestPalindrome("aaaa"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
