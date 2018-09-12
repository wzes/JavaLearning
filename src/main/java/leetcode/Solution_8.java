package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/3/18
 */
public class Solution_8 {

    @Test
    public void AtoiTest() {
        Assert.assertEquals(0, myAtoi(""));
        Assert.assertEquals(123, myAtoi("+123"));
        Assert.assertEquals(123, myAtoi("123"));
        Assert.assertEquals(-123, myAtoi("-123"));
        Assert.assertEquals(-123, myAtoi("  -123"));
        Assert.assertEquals(-0, myAtoi("-0"));
        Assert.assertEquals(Integer.MAX_VALUE, myAtoi("214748364721"));
        Assert.assertEquals(Integer.MIN_VALUE, myAtoi("  -123123111213"));
        Assert.assertEquals(Integer.MAX_VALUE, myAtoi("2147483648"));
        Assert.assertEquals(0, myAtoi("my 2147483648"));
        Assert.assertEquals(12, myAtoi("12 my"));

        Assert.assertEquals(12, Integer.parseInt("12"));
        System.out.println(Character.digit('F',16));
    }

    public int myAtoi(String str) {
        String trim = str.trim();
        if (trim.length() == 0) {
            return 0;
        }
        boolean negative = trim.charAt(0) == '-';
        boolean notNegative = trim.charAt(0) == '+';
        char[] chars = trim.toCharArray();
        int i = negative ? 1 : notNegative ? 1 : 0, num = 0;
        while (i < chars.length) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                int pop = (chars[i++] - '0');
                if (!negative && (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && pop > 7))) {
                    return Integer.MAX_VALUE;
                }
                if (negative && (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && pop > 8))) {
                    return Integer.MIN_VALUE;
                }
                num = num * 10 + pop;
            } else if (i == 0) {
                return 0;
            } else {
                break;
            }
        }
        return negative ? -num : num;
    }
}
