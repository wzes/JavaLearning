package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_104 {

    @Test
    public void LevelOrderTest() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        Assert.assertEquals(3, maxDepth(treeNode));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return l > r ? l + 1 : r + 1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
