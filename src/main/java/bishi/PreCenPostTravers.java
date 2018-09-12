package bishi;

import org.junit.Test;

import java.util.Stack;

/**
 * @author Create by xuantang
 * @date on 9/7/18
 */
public class PreCenPostTravers {

    @Test
    public void TraverseTest() {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);
        // preTraverse(treeNode);
        // inTraverse(treeNode);
        postTraverse(treeNode);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void preTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                p = pop.right;
            }
        }
    }

    public void inTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                p = pop.right;
            }
        }
    }

    public void postTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null, cur;
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) ||
                    (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.println(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }
}
