package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_414 {
    @Test
    public void ThirdMax() {
        Assert.assertEquals(2, thirdMax(new int[]{1, 2, 4, 6}));
        Assert.assertEquals(2, thirdMax(new int[]{1, 2}));
        Assert.assertEquals(-2147483648, thirdMax(new int[]{1, 2, -2147483648}));
    }

    public int thirdMax(int[] nums) {
        //ini
        Integer max1 = null, max2 = null, max3 = null;

        //for loop, change
        for (int n : nums) {
            if ((max1 != null && n == max1) || (max2 != null && n == max2) ||
                    (max3 != null && n == max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        //return
        return (max3 == null) ? max1 : max3;
    }
}
