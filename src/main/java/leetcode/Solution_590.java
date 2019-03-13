package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution_590 {

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return list;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            list.add(temp.val);
            for (int i = 0; i <= temp.children.size() - 1; i++) {
                stack.push(temp.children.get(i));
            }

        }
        Collections.reverse(list);
        return list;
    }
}
