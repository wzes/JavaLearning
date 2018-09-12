package leetcode;

import java.util.*;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> stack = new ArrayList<>();
        dfs(nums, set, stack, 0);
        return new ArrayList<>(set);
    }

    void dfs(int[] nums, Set<List<Integer>> set, List<Integer> tmp, int k) {
        if (tmp.size() >= 2) {
            List<Integer> integers = new ArrayList<>(tmp.size());
            integers.addAll(tmp);
            set.add(integers);
        }
        for (int i = k; i < nums.length; i++) {
            if (tmp.size() == 0 || tmp.get(tmp.size() - 1) <= nums[i]) {
                tmp.add(nums[i]);
                dfs(nums, set, tmp, i + 1);
                tmp.remove(0);
            }
        }
    }

}
