package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_215 {
    @Test
    public void findLargestTest() {
        Assert.assertEquals(2, findKthLargest(new int[]{1, 2, 3}, 2));

        Assert.assertEquals(4, findKthLargest(new int[]{1, 4, 5, 2, 3}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();

    }
}
