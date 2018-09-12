package leetcode;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class Solution_105 {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length==0){
            return null;
        }
        return buildCore(preorder,0,preorder.length - 1, inorder,0,inorder.length - 1);
    }


    private TreeNode buildCore(int[] preorder, int preSt, int preEnd, int[] inorder, int inSt, int inEnd){
        int rootValue = preorder[preSt];
        TreeNode root = new TreeNode(rootValue);
        if (preSt == preEnd) {
            return root;
        }
        int rootInorder = inSt;
        while (inorder[rootInorder] != rootValue && rootInorder <= inEnd){
            rootInorder++;
        }
        int leftLength = rootInorder - inSt;
        int leftPreEnd = preSt + leftLength;
        if (leftLength > 0) {
            root.left = buildCore(preorder,preSt + 1, leftPreEnd, inorder, inSt, inEnd);
        }
        if (leftLength < preEnd - preSt) {
            root.right = buildCore(preorder,leftPreEnd + 1, preEnd, inorder,rootInorder + 1, inEnd);
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
