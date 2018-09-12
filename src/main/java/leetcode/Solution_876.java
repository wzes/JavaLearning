package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/4/18
 */
public class Solution_876 {
    @Test
    public void NodeTest() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        Assert.assertEquals(3, middleNode(node).val);
        Assert.assertEquals(4, middleNode(node.next).val);
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

    }
}
