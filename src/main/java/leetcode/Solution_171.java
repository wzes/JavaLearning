package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_171 {
    public int titleToNumber(String s) {
        int i = 0, number = 0;
        while (i < s.length()) {
            number = number * 26 + (s.charAt(i) - 64);
            i++;
        }
        return number;
    }

    @Test
    public void Test() {
        Assert.assertEquals(1, titleToNumber("A"));
        Assert.assertEquals(27, titleToNumber("AA"));
        Assert.assertEquals(701, titleToNumber("ZY"));
    }
}
