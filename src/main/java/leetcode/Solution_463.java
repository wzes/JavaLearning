package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_463 {

    @Test
    public void Solution_463_Test() {
        Assert.assertEquals(20, islandPerimeter(new int[][]{
                {
                        0, 1, 0, 0
                },
                {
                        1, 1, 1, 0
                },
                {
                        0, 1, 0, 0
                },
                {
                        1, 1, 0, 1
                }
        }));
    }

    final int[][] dirs = new int[][]{
            {-1, 0}, // left,
            {1, 0}, // right
            {0, -1}, // up
            {0, 1} // down
    };

    int islandPerimeter = 0;
//    public int islandPerimeter(int[][] grid) {
//        boolean[][] visit = new boolean[grid.length][grid[0].length];
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1 && !visit[i][j]) {
//                    visit[i][j] = true;
//                    find(visit, grid, i, j);
//                }
//            }
//        }
//        return islandPerimeter;
//    }

    private void find(boolean[][] visit, int[][] grid, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nc = dirs[i][0] + c;
            int nr = dirs[i][1] + r;
            if (nr < grid.length && nr >= 0 && nc >= 0 && nc < grid[0].length) {
                if (visit[nr][nc]) {
                    continue;
                }
                if (grid[nr][nc] == 0) {
                    islandPerimeter++;
                } else {
                    visit[nr][nc] = true;
                    // find more
                    find(visit, grid, nr, nc);
                }
            } else { // border
                islandPerimeter++;
            }
        }
    }

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = res + 4;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) // right
                        res = res - 2;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) // down
                        res = res - 2;
                }
            }
        }
        return res;
    }

}
