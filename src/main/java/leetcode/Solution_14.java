package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_14 {

    @Test
    public void LongestCommonPrefix() {
        Assert.assertEquals("cl", longestCommonPrefix(new String[]{"cl", "clr", "clone"}));
        Assert.assertEquals("a", longestCommonPrefix(new String[]{"aa", "a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
