package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_162 {

    @Test
    public void Solution_162_Test() {
        Assert.assertEquals(6, findPeakElement(new int[]{1, 2, 1, 2, 4, 5, 6}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
