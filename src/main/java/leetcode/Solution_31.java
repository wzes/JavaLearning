package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int swapIndex = nums.length - 1;
        while (swapIndex > 0 && nums[swapIndex] <= nums[swapIndex - 1]) swapIndex--;
        if (swapIndex == 0) {
            // reverse
            reverse(nums, 0, nums.length - 1);
        } else {
            swapIndex--;
            final int num = nums[swapIndex];
            int anoSwapIndex = nums.length - 1;
            while (anoSwapIndex >= 0) {
                if (nums[anoSwapIndex] > num) {
                    break;
                }
                anoSwapIndex--;
            }
            nums[swapIndex] = nums[anoSwapIndex];
            nums[anoSwapIndex] = num;
            reverse(nums, swapIndex + 1, nums.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        for (int i = 0; i < (end - start + 1) >> 1; i++) {
            final int tmp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = tmp;
        }
    }

    @Test
    public void Test() {
        int[] nums = {3, 2, 1};
        nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, nums);

        nums = new int[]{2, 3, 1};
        nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{3, 1, 2}, nums);

        nums = new int[]{1, 1};
        nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 1}, nums);

        nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{2, 1, 3}, nums);

        nums = new int[]{1, 2, 3};
        nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 3, 2}, nums);

        nums = new int[]{1, 1, 5};
        nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 5, 1}, nums);
    }
}
