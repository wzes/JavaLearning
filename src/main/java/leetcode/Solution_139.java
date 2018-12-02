package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i + 1));
            for (int j = 0; j <= i; j++) {
                if (res[j] && wordDict.contains(str.toString())) {
                    res[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }

    @Test
    public void Test() {
        Assert.assertTrue(wordBreak("cars", Arrays.asList("car", "ca", "rs")));
        Assert.assertFalse(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
                "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
        Assert.assertTrue(wordBreak("cars", Arrays.asList("car", "ca", "rs")));
        Assert.assertTrue(wordBreak("leet", Arrays.asList("leet", "code")));
        Assert.assertTrue(wordBreak("leetcode", Arrays.asList("leet", "code")));
        Assert.assertTrue(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        Assert.assertFalse(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
