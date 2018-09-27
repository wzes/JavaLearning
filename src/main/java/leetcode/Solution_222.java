package leetcode;

import org.junit.Assert;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_222 {

    @Test
    public void LevelOrderTest() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        Assert.assertEquals(5, countNodes(treeNode));
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        if (lDepth == rDepth)
            return (1 << lDepth) + countNodes(root.right);
        else
            return (1 << rDepth) + countNodes(root.left);
    }

    int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
