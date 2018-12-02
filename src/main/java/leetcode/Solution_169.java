package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution_169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxNum = nums[0];
        int maxCount = 1;
        for (int num : nums) {
            if (map.containsKey(num)) {
                final int count = map.get(num) + 1;
                map.put(num, count);
                if (maxCount < count) {
                    maxCount = count;
                    maxNum = num;
                }
            } else {
                map.put(num, 1);
            }
        }
        return maxNum;
    }

    @Test
    public void Test() {
        Assert.assertEquals(2, majorityElement(new int[]{1, 2, 2}));
        Assert.assertEquals(2, majorityElement(new int[]{2, 1, 1, 1, 2, 2, 2}));

    }
}
