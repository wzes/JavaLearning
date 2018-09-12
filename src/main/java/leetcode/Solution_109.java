package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/6/18
 */
public class Solution_109 {
    @Test
    public void NodeTest() {
        ListNode node = new ListNode(-10);
        node.next = new ListNode(-3);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(5);
        TreeNode treeNode = sortedListToBST(node);
        System.out.println(treeNode.val);

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

    public TreeNode sortedListToBST(ListNode head) {
        return BST(head, null);
    }

    TreeNode BST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = BST(head, slow);
        treeNode.right = BST(slow.next, tail);
        return treeNode;
    }
}
