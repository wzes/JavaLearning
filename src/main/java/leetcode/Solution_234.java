package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/12/18
 */
public class Solution_234 {

    @Test
    public void PalindromeTest() {
        ListNode node = new ListNode(2);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next= new ListNode(2);
        Assert.assertTrue(isPalindrome(node));

        node = new ListNode(2);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(2);
        Assert.assertTrue(isPalindrome(node));

        node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(2);
        Assert.assertTrue(isPalindrome(node));

        node = new ListNode(2);
        node.next = new ListNode(2);
        Assert.assertTrue(isPalindrome(node));

        node = new ListNode(2);
        node.next = new ListNode(1);
        Assert.assertFalse(isPalindrome(node));
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public boolean isPalindrome(ListNode head) {
        ListNode cur = head, fast = head;
        ListNode pre = new ListNode(0);
        ListNode tmp;
        // find the middle node
        while (fast != null && fast.next != null) {
            // move
            fast = fast.next.next;
            // reverse
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // not odd
        if (fast != null) {
            cur = cur.next;
        }
        // compare
        while (pre != null && cur != null) {
            if (pre.val != cur.val) {
                return false;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
}
