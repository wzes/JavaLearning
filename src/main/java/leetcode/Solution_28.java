package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_28 {
    @Test
    public void StrTest() {
        Assert.assertEquals(0, strStr("aaa", ""));
        Assert.assertEquals(0, strStr("aaa", "value"));
        Assert.assertEquals(-1, strStr("aaa", "b"));
        Assert.assertEquals(2, strStr("abba", "ba"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            while (j < needle.length() && i + j < haystack.length() && (haystack.charAt(i + j) == needle.charAt(j))) { j++; }
            if (j == needle.length()) return i;
        }
        return -1;
    }
}
