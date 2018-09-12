package leetcode;

import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/6/18
 */
public class Solution_108 {
    @Test
    public void NodeTest() {
        TreeNode treeNode = sortedArrayToBST(new int[]{1, 2, 3, 4});
        System.out.println(treeNode.val);

    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums, 0, nums.length - 1);
    }

    public TreeNode BST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, left, mid - 1);
        root.right = BST(nums, mid + 1, right);
        return root;
    }
}
