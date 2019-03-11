package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

public class Solution_113 {

    @Test
    public void Test() {
        TreeNode treeNode = TreeNode.buildTree("[5,3,1,1,null,null,3]");
        pathSum(treeNode, 9);

        Assert.assertEquals(2, paths.size());
    }

    List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return paths;
        find(root, res, sum);
        return paths;
    }

    public void find(TreeNode root, List<Integer> res, int sum) {
        if (root == null) return;
        res.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                paths.add(new ArrayList<>(res));
            }
            res.remove(res.size() - 1);//return前自觉出栈
            return;
        }
        find(root.left, res, sum - root.val);
        find(root.right, res, sum - root.val);
        res.remove(res.size() - 1);//return前自觉出栈
    }
}
