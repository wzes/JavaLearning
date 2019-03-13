package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_46 {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
        }
        int[] backup = Arrays.copyOf(nums, nums.length);
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            dfs(nums, index + 1);
            nums = Arrays.copyOf(backup, nums.length);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
