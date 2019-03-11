package leetcode;


/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        TreeNode copy = buildTree("[1,2,3,null,null,5,6]");
        System.out.println(copy.right.right.val);
    }

    static TreeNode buildTree(String data) {
        if (data == null || data.length() == 0) {
             return null;
        }
        return decode(numbers(data), 0);
    }

    private static String[] numbers(String data) {
        if (data.charAt(0) == '[' && data.charAt(data.length() - 1) == ']') {
            return data.substring(1, data.length() - 1).split(",");
        }
        return data.split(",");
    }

    private static TreeNode decode(String[] numbers, int index) {
        // null
        if (index >= numbers.length || numbers[index].trim().equals("null")) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(numbers[index].trim()));
        treeNode.left = decode(numbers, index * 2 + 1);
        treeNode.right = decode(numbers, index * 2 + 2);
        return treeNode;
    }

    /**
     * Judge two tree nodes is same ot not
     *
     * @param one first tree node
     * @param other second tree node
     * @return true is same, false is not same
     */
    public static boolean isSame(TreeNode one, TreeNode other) {
        if (one == null && other == null) {
            return true;
        } else if (one != null && other != null) {
            return isSame(one.left, other.left) && isSame(one.right, other.right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TreeNode)) {
            return false;
        }
        return isSame(this, (TreeNode) obj);
    }
}
