package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author Create by xuantang
 * @date on 8/25/18
 */
public class Solution_1 {


    @Test
    public void Solution() {
        Assert.assertArrayEquals(new int[]{0, 1}, twoSum(new int[]{2, 7, 12, 15}, 9));

        Assert.assertArrayEquals(new int[]{0, 1}, twoSum_hash(new int[]{2, 7, 12, 15}, 9));
    }

    public int[] twoSum(int[] nums, int target) {
        int i, j;
        for (i = 0; i < nums.length; i++) {
            for (j = nums.length - 1; j > i; j--) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSum_hash(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int element = target - nums[i];
            if (hashMap.containsKey(element) && hashMap.get(element) != i) {
                return new int[]{hashMap.get(element), i};
            }
            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
