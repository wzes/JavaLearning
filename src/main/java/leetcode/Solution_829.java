package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_829 {


    @Test
    public void consectiveNumbersSum() {
        Assert.assertEquals(4, consecutiveNumbersSum(15));
        Assert.assertEquals(2, consecutiveNumbersSum(5));
        Assert.assertEquals(1, consecutiveNumbersSum(1));
    }
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        int iniSum = 0;
        for (int i = 1; i * (i + 1) / 2 <= N; i++) {
            iniSum = i * (i + 1) / 2;
            if ((N - iniSum) % i == 0) res++;
        }
        return res;
    }
}
