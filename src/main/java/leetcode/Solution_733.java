package leetcode;

import org.junit.Test;

public class Solution_733 {

    @Test
    public void Solution_733_Test() {
        floodFill(new int[][]{{0,0,0},{0,0,0}}, 0, 0, 2);
    }

    private int[][] dirs = new int[][]{
            {-1, 0}, // left,
            {1, 0}, // right
            {0, -1}, // up
            {0, 1} // down
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visit = new boolean[image.length][image[0].length];
        visit[sr][sc] = true;
        int num = image[sr][sc];
        image[sr][sc] = newColor;
        find(visit, image, sr, sc, newColor, num);
        return image;
    }

    private void find(boolean[][] visit, int[][] image, int sr, int sc, int newColor, int val) {
        for (int i = 0; i < 4; i++) {
            int r = dirs[i][1] + sr;
            int c = dirs[i][0] + sc;
            if (r >= 0 && c < image[0].length && r < image.length && c >= 0 && !visit[r][c]) {
                visit[r][c] = true;
                if (image[r][c] == val) {
                    image[r][c] = newColor;
                    find(visit, image, r, c, newColor, val);
                }
            }
        }
    }
}
