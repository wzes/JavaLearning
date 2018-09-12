package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/4/18
 */
public class Solution_19 {
    @Test
    public void NodeTest() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        Assert.assertEquals(1, removeNthFromEnd(node, 2).val);

    }

    @Test
    public void NodeTest2() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        Assert.assertEquals(2, removeNthFromEnd(node, 3).val);

    }

    @Test
    public void NodeTest3() {
        ListNode node = new ListNode(1);
        Assert.assertEquals(null, removeNthFromEnd(node, 1));

    }

    @Test
    public void NodeTest4() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        Assert.assertEquals(1, removeNthFromEnd(node, 1).val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy;
        while ( n >= 0 && cur != null) {
            cur = cur.next;
            n--;
        }
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummy.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
