package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_144 {

    @Test
    public void Inorder() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        Assert.assertEquals(5, preorderTraversal(treeNode).get(0).intValue());
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> integers = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                integers.add(p.val);
                p = p.left;
            }
            // visit node
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                p = pop.right;
            }
        }
        return integers;
    }
}
