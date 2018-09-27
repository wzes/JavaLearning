package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_541 {

    @Test
    public void ReverseTest() {
        Assert.assertEquals("bacdfeg", reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int i = 0;
        while (i < chs.length) {
            if (i + 2 * k < chs.length) {
                reverse(chs, i, i + k - 1);
                i = i + 2 * k;
            } else if (i + k < chs.length) {
                reverse(chs, i, i + k - 1);
                break;
            } else if (i + k >= chs.length) {
                reverse(chs, i, chs.length - 1);
                break;
            }
        }
        StringBuilder str = new StringBuilder();
        for (char ch : chs) str.append(ch);
        return str.toString();
    }

    private void reverse(char[] chs, int i, int j) {
        for (int start = i; start < (j + i + 1) / 2; start++) {
            swap(chs, start, j - (start - i));
        }
    }

    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
