package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution_15 {


    @Test
    public void ThreeSumTest() {
        Assert.assertEquals(2, threeSum(new int[]{-1, 0, 1, 2, -1, -4}).size());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    list.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }

            }
        }
        return list;
    }
}
