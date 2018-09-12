package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 9/2/18
 */
public class Solution_6 {
    @Test
    public void SolutionTest() {
        Assert.assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        Assert.assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
        Assert.assertEquals("P", convert("P", 1));
    }


    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        List<List<Character>> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) rows.add(new LinkedList<>());
        char[] chars = s.toCharArray();
        int i = 0, size = chars.length;
        while (i < size) {
            int m = 0, n = numRows - 1;
            while (m < n && i < size) {
                rows.get(m++).add(chars[i++]);
            }
            while (n > 0 && i < size) {
                rows.get(n--).add(chars[i++]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : rows) {
            for (Character c : list) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
