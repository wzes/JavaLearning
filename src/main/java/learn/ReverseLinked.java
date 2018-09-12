package learn;

/**
 * @author Create by xuantang
 * @date on 6/11/18
 */
public class ReverseLinked {
    static class Node {
        private int data;
        private Node next;

        @Override
        public String toString() {
            return data + "";
        }

        public Node(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.setNext(new Node(2));
        head.getNext().setNext(new Node(3));
        head.getNext().getNext().setNext(new Node(4));

        //reverse(head, null);

        //reverse(head);
        Node pre = reverse(head);
        while (pre != null) {
            System.out.println(pre.data);
            pre = pre.next;
        }
    }

    private static Node reverse(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node reverseNode = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reverseNode;
    }


    private static void reverse(Node head, Object o) {
        Node cur = head.getNext();
        Node pre = head;
        Node tmp;
        while (cur != null) {
            tmp = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = tmp;
        }
        head.setNext(null);
        while (pre != null) {
            System.out.println(pre.data);
            pre = pre.next;
        }
    }
}
