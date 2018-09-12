package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_226 {

    @Test
    public void LevelOrderTest() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.left.left = new TreeNode(1);
        invertTree(treeNode);
    }
    public TreeNode invertTree(TreeNode root) {
        if (root != null && (root.left != null || root.right != null)) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
