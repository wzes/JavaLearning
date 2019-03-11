package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {


    @Test
    public void Test() {
        TreeNode treeNode = TreeNode.buildTree("[1,2,3,null,5]");
        Assert.assertArrayEquals(new String[]{"1->2->5", "1->3"}, binaryTreePaths(treeNode).toArray());

        treeNode = TreeNode.buildTree("[1,2,3]");
        Assert.assertArrayEquals(new String[]{"1->2", "1->3"}, binaryTreePaths(treeNode).toArray());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();

        String path = "";
        findPath(root, result, path);
        return result;
    }

    private void findPath(TreeNode root, List<String> list, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        if (root.left != null) {
            findPath(root.left, list, path + "->");
        }
        if (root.right != null) {
            findPath(root.right, list, path + "->");
        }
        if (root.left == null && root.right == null) {
            list.add(path);
        }
    }
}
