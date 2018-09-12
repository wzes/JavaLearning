package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_67 {
    @Test
    public void BinaryAdd() {
        Assert.assertEquals("110", addBinary("10", "100"));
        Assert.assertEquals("100", addBinary("11", "1"));
        Assert.assertEquals("110", addBinary("11", "11"));
        Assert.assertEquals("10001", addBinary("10000", "1"));
        Assert.assertEquals("0", addBinary("0", "0"));
    }


    public String addBinary(String a, String b) {
        int len1 = a.length(),len2 = b.length();
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1, j = len2-1, carry = 0;
        while(i >= 0 || j >= 0){
            int x = (i >= 0) ? a.charAt(i) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 2;
            sb.append(sum % 2);
            i--;
            j--;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}
