package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_162 {

    @Test
    public void Solution_162_Test() {
        Assert.assertEquals(2, findPeakElement(new int[]{1, 2, 1, 2, 4, 5}));
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if ((mid <= l || nums[mid] > nums[mid - 1]) &&
                    (mid >= r || nums[mid] > nums[mid + 1]))
                return mid;
            if (mid <= l || nums[mid] > nums[mid - 1])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
