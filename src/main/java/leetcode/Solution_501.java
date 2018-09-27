package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_501 {

    @Test
    public void Test() {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(1);
        node.right = new TreeNode(2);
//
//        node.right.right = new TreeNode(3);
//        node.right.left = new TreeNode(3);
        Assert.assertArrayEquals(new int[]{2}, findMode(node));
    }

    int max = 0;
    List<Integer> list = new ArrayList<>();
    int cur = 0;
    int count = 0;

    public int[] findMode(TreeNode root) {
        findSameNode(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void findSameNode(TreeNode node) {
        if (node == null) {
            return;
        }
        findSameNode(node.left);
        count++;
        if (node.val != cur) {
            count = 1;
            cur = node.val;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(cur);
        } else if (count == max) {
            list.add(cur);
        }
        findSameNode(node.right);
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
