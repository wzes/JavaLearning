package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author Create by xuantang
 * @date on 9/5/18
 */
public class Solution_83 {
    @Test
    public void DeleteTest() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        Assert.assertEquals(1, deleteDuplicates(node).val);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head.next;
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(head.val, new Object());
        ListNode pre = head;
        while (cur!= null) {
            if (hashMap.containsKey(cur.val)) {
                pre.next = cur.next;
            } else {
                hashMap.put(cur.val, new Object());
                pre = pre.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
