package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_10 {

    @Test
    public void MatchTest() {
        Assert.assertTrue(isMatch("ab", ".*"));
        Assert.assertFalse(isMatch("ab", "a*"));
        Assert.assertTrue(isMatch("aab", ".*b"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));
        Assert.assertFalse(isMatch("mississippi", "mis*is*p*."));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean first_match = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (first_match && isMatch(s.substring(1), p)));
        } else {
            return first_match && isMatch(s.substring(1), p.substring(1));
        }
    }
}
