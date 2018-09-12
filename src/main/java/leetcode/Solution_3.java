package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * @author Create by xuantang
 * @date on 8/26/18
 */
public class Solution_3 {

    @Test
    public void Solution() {
        Assert.assertEquals(3, lengthOfLongestSubstring2("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring2("bbbbbb"));
        Assert.assertEquals(3, lengthOfLongestSubstring2("pwwkew"));
        Assert.assertEquals(2, lengthOfLongestSubstring2("aab"));
        Assert.assertEquals(0, lengthOfLongestSubstring2(""));
        Assert.assertEquals(3, lengthOfLongestSubstring2("dvdf"));
        Assert.assertEquals(4, lengthOfLongestSubstring2("dcvdf"));
        Assert.assertEquals(2, lengthOfLongestSubstring2("abba"));
    }


    /**
     *
     *
     * @param s
     * @return
     */
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 1) {
//            return 1;
//        }
//        char lastChar = s.charAt(s.length() - 1);
//        String tmp = s.substring(0, s.length() - 1);
//        if (tmp.indexOf(lastChar) != -1) {
//            return lengthOfLongestSubstring(tmp);
//        } else {
//            return lengthOfLongestSubstring(tmp) + 1;
//        }
//    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1, index = 0, tmpLength = 1;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            boolean find = false;
            for (int j = i - 1; j >= index; j--) {
                if (chars[i] == chars[j]) {
                    find = true;
                    index = j + 1;
                }
            }
            tmpLength = find ? i - index + 1 : tmpLength + 1;
            maxLength = maxLength < tmpLength ? tmpLength : maxLength;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> hashMap = new HashMap<>();
        int maxLength = 0, tmpLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                tmpLength = i - hashMap.get(s.charAt(i));
            } else {
                tmpLength++;
            }
            hashMap.put(s.charAt(i), i);
            maxLength = Math.max(tmpLength, maxLength);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            int ch = s.charAt(j);
            i = Math.max(index[ch], i);
            ans = Math.max(ans, j - i + 1);
            index[ch] = j + 1;
        }
        return ans;
    }
}
