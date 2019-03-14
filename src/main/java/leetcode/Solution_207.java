package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution_207 {

    @Test
    public void Solution_207_Test() {
        boolean b = canFinish(2, new int[][]{
                {
                        1, 0
                },
                {
                        0, 1
                }
        });
        Assert.assertFalse(b);
    }

    private boolean[] marked;
    private boolean[] onStack;
    private List<Integer>[] adj;
    private boolean res;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) return true;
        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];

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
        return !res;
    }

    private void dfs(int v) {
        onStack[v] = true;
        marked[v] = true;
        for (Integer u : adj[v]) {
            if (res) {
                return;
            }
            else if (!marked[u]) {
                dfs(u);
            }
            else if (onStack[u]) {
                res = true;
            }
        }
        onStack[v] = false;
    }
}
