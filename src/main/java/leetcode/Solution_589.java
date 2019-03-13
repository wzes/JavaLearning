package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_589 {

    @Test
    public void Test() {
        Node node = new Node(1, null);
        Assert.assertEquals(Arrays.asList(1), preorder(node));
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        } else {
            result.add(root.val);
            if (root.children != null) {
                for (Node node : root.children) {
                    preorder(node);
                }
            }
        }
        return result;
    }
}
