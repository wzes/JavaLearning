package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/9/18
 */
public class Solution_287 {

    @Test
    public void DuplicateTest() {
        Assert.assertEquals(2, findDuplicate(new int[]{2, 2, 3, 4, 1}));
        Assert.assertEquals(2, findDuplicate(new int[]{2, 2, 2, 2, 2}));
        Assert.assertEquals(1, findDuplicate(new int[]{2, 3, 1, 4, 1}));
        Assert.assertEquals(1, findDuplicate(new int[]{2, 3, 1, 4, 1}));
    }


    public int findDuplicate(int[] nums) {
        int high = nums.length-1;
        int low = 0;
        while (high > low) {
            int mid = (high + low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}
