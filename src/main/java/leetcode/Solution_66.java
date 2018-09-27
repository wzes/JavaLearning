package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_66 {

    @Test
    public void PlusOneTest() {
        Assert.assertArrayEquals(new int[]{1, 2, 3}, plusOne(new int[]{1, 2, 2}));
        Assert.assertArrayEquals(new int[]{1, 0, 0}, plusOne(new int[]{9, 9}));
        Assert.assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
    }

    public int[] plusOne(int[] digits) {
        int l = digits.length;
        while (true) {
            if (digits[l - 1] == 9) {
                digits[l - 1] = 0;
                l--;
                if (l == 0) {
                    int[] r = new int[digits.length+1];
                    r[0] = 1;
                    return r;

                }
            } else {
                digits[l-1] += 1;
                return digits;
            }
        }
    }
}
