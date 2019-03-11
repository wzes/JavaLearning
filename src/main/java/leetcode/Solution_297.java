package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution_297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "$,";
        }
        return root.val + "," + serialize(root.left)
                + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Queue<String> queue = new ArrayDeque<>(Arrays.asList(strings));
        return func(queue);
    }

    private TreeNode func(Queue<String> strings) {
        String string = strings.remove();
        if ("$".equals(string)) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(string));
        newNode.left = func(strings);
        newNode.right = func(strings);
        return newNode;
    }
}
