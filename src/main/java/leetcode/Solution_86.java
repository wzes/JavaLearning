package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/4/18
 */
public class Solution_86 {
    @Test
    public void NodeTest() {
        ListNode node = new ListNode(2);
        //Assert.assertEquals(2, partition(node, 2).val);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next= new ListNode(2);
//        Assert.assertEquals(1, partition(node, 3).next.next.val);
//        Assert.assertEquals(2, partition(node, 5).val);
        Assert.assertEquals(1, partition(node.next.next, 4).val);
    }

    @Test
    public void NodeTest2() {
        ListNode node = new ListNode(3);
        //Assert.assertEquals(2, partition(node, 2).val);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        Assert.assertEquals(3, partition(node, 3).next.next.val);
    }

    public ListNode partition(ListNode head, int x) {
        // write code here
        if(head == null) {
            return head;
        }
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode result = list1;
        ListNode tmp = list2;
        while (head != null) {
            if (head.val < x) {
                list1.next = head;
                list1 = list1.next;
            } else {
                list2.next = head;
                list2 = list2.next;
            }
            head = head.next;
        }
        list1.next = tmp.next;
        list2.next = null;
        return result.next;

    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
