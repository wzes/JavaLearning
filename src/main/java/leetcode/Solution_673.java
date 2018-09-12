package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_673 {

    @Test
    public void LevelOrderTest() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        System.out.println(averageOfLevels(treeNode).get(0).doubleValue());
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root;
        queue.add(p);
        while (!queue.isEmpty()) {
            int count = queue.size();
            int preSize = count;
            double sum = 0;
            while (count-- > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                sum += (double) node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            lists.add(sum / preSize);
        }
        return lists;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
