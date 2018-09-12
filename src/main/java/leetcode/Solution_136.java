package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/9/18
 */
public class Solution_136 {

    @Test
    public void Test() {
        Assert.assertEquals(3, singleNumber(new int[]{2, 5, 3, 2, 5}));
        Assert.assertEquals(1, singleNumber(new int[]{2, 2, 1}));
    }

    public int singleNumber(int[] nums) {
        int n = nums[0];
        for (int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
}
