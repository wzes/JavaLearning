package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_11 {

    @Test
    public void MaxAreaTest() {
        Assert.assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(2, maxArea2(new int[]{1,6,2}));
    }


    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(Math.min(height[r], height[l]) * (r - l), max);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
