package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Create by xuantang
 * @date on 8/31/18
 */
public class Solution_628 {

    @Test
    public void Product() {
        Assert.assertEquals(6, maximumProduct(new int[]{1, 2, 3}));
        Assert.assertEquals(24, maximumProduct(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(80, maximumProduct(new int[]{-10, -2, 3, 4}));
        Assert.assertEquals(-20, maximumProduct(new int[]{-10, -2, -1}));
        Assert.assertEquals(0, maximumProduct(new int[]{-10, -2, -1, 0}));
    }

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int backThree = nums[0] * nums[1] * nums[n - 1];
        int beforeThree = nums[n - 1] * nums[n - 2] * nums[n - 3];
        return Math.max(backThree, beforeThree);
    }
}
