package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 8/25/18
 */
public class Solution_2 {

    @Test
    public void Solution() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        Assert.assertEquals(7, listNode.val);
        Assert.assertEquals(0, listNode.next.val);
        Assert.assertEquals(8, listNode.next.next.val);
    }

    @Test
    public void Solution2() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        Assert.assertEquals(0, listNode.val);
        Assert.assertEquals(0, listNode.next.val);
        Assert.assertEquals(1, listNode.next.next.val);
    }

    @Test
    public void Solution3() {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        Assert.assertEquals(8, listNode.val);
        Assert.assertEquals(0, listNode.next.val);
        Assert.assertEquals(1, listNode.next.next.val);
    }

    @Test
    public void Solution4() {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);
        ListNode listNode = addTwoNumbers(l1, l2);
        Assert.assertEquals(2, listNode.val);
        Assert.assertEquals(0, listNode.next.val);
        Assert.assertEquals(1, listNode.next.next.val);
    }

    private ListNode reverse(ListNode l1) {
        if (l1 == null) {
            throw new IllegalStateException("l1 illegal");
        }
        if (l1.next == null) {
            return l1;
        }
        ListNode pre = l1;
        ListNode cur = l1.next;
        pre.next = null;
        // reverse list
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carryNum = 0;
        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carryNum;
            ListNode tmp = new ListNode(sum % 10);
            carryNum = sum / 10;
            cur = cur.next = tmp;
            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1 != null) {
            int sum = node1.val + carryNum;
            ListNode tmp = new ListNode(sum % 10);
            carryNum = sum / 10;
            cur = cur.next = tmp;
            node1 = node1.next;
        }
        while (node2 != null) {
            int sum = node2.val + carryNum;
            ListNode tmp = new ListNode(sum % 10);
            carryNum = sum / 10;
            cur = cur.next = tmp;
            node2 = node2.next;
        }
        if (carryNum != 0) {
            cur.next = new ListNode(carryNum);
        }
        return head.next;
    }

    public ListNode addTwoNumbers_official(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
