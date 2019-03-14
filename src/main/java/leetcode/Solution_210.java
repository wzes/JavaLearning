package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_210 {

    @Test
    public void Solution_210_Test() {
    }

    private boolean[] marked;
    private boolean[] onStack;
    private List<Integer>[] adj;
    private Stack<Integer> st;
    private boolean hasCycle;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        st = new Stack<>();

        adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        // record the visit map
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // visit
        for (int i = 0; i < numCourses; i++) {
            if (!marked[i]) {
                dfs(i);
            }
        }
        if (hasCycle) {
            return new int[0];
        }
        int[] res = new int[st.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = st.pop();
        return res;
    }

    private void dfs(int v) {
        onStack[v] = true;
        marked[v] = true;
        for (Integer u : adj[v]) {
            if (hasCycle) {
                return;
            } else if (!marked[u]) {
                dfs(u);
            } else if (onStack[u]) {
                hasCycle = true;
            }
        }
        onStack[v] = false;
        st.push(v);
    }
}
