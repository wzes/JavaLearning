package leetcode;

public class Solution_988 {


    public String smallestFromLeaf(TreeNode root) {
        // 节点值为[0,25]，所以需要加上'a'来获得对应的char
        char c = (char)('a' + root.val);
        if (root.left == null && root.right == null) {//无左右子树
            return "" + c;
        } else if (root.left == null) {//左子树为空，遍历右子树
            String str = smallestFromLeaf(root.right);
            return str + c;//
        } else if (root.right == null) {//右子树为空，遍历左子树
            return smallestFromLeaf(root.left) + c;
        } else {//左右子树都不为空
            String s1 = smallestFromLeaf(root.left);
            String s2 = smallestFromLeaf(root.right);
            if (s1.compareTo(s2) < 0) {//比较左右子树的最小字符串
                return s1 + c;
            } else {
                return s2 + c;
            }
        }
    }
}
