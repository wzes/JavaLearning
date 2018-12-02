package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int tmp = 0;
        for (int num : nums) {
            if (num == 1) {
                tmp++;
            } else {
                max = Math.max(tmp, max);
                tmp = 0;
            }
        }
        max = Math.max(tmp, max);
        return max;
    }


    @Test
    public void Test() {
        Assert.assertEquals(3, findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        Assert.assertEquals(6, findMaxConsecutiveOnes(new int[]{1, 1, 1, 1, 1, 1}));
        Assert.assertEquals(0, findMaxConsecutiveOnes(new int[]{0}));
        Assert.assertEquals(1, findMaxConsecutiveOnes(new int[]{1}));
    }
}
