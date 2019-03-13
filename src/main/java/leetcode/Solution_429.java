package leetcode;

import java.util.*;

public class Solution_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> integers = new ArrayList<>();
        if (root == null) {
            return integers;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            final List<Integer> level = new ArrayList<>();
            while (count-- > 0) {
                Node tmp = queue.poll();
                if (tmp == null) {
                    continue;
                }
                queue.addAll(tmp.children);
                level.add(tmp.val);
            }
            integers.add(level);
        }
        return integers;
    }
}
