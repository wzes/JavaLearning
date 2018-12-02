package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_172 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 1)
            count += (n /= 5);
        return count;
    }

    @Test
    public void Test() {
        Assert.assertEquals(1, trailingZeroes(5));
    }
}
