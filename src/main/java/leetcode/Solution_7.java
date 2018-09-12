package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/3/18
 */
public class Solution_7 {

    @Test
    public void ReverseTest() {
        Assert.assertEquals(321, reverse(123));
        Assert.assertEquals(-321, reverse(-123));
        Assert.assertEquals(12, reverse(210));
        Assert.assertEquals(0, reverse(-1221212127));
        Assert.assertEquals(0, reverse(1534236469));
        Assert.assertEquals(0, reverse(Integer.MAX_VALUE));
        Assert.assertEquals(2147483641, reverse(1463847412));
        Assert.assertEquals(0, reverse(1563847412));
    }

    public int reverse(int x) {
        int m = Math.abs(x), n = 0;
        while(m > 0) {
            n = m % 10 + n * 10;
            m = m / 10;
            // over flow
            if (n > Integer.MAX_VALUE / 10 && m != 0) {
                return 0;
            }
        }
        return x > 0 ? n : -n;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
