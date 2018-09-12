package jd;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author Create by xuantang
 * @date on 9/9/18
 */
public class Main {
    @Test
    public void FillGridTest() {
        Assert.assertEquals(5, fillGrid(3, 4, 2, 2, 2));
        Assert.assertEquals(4, fillGrid(3, 4, 2, 2, 1));
        Assert.assertEquals(1, fillGrid(3, 4, 2, 2, 0));
        Assert.assertEquals(1, fillGrid(3, 3, 2, 2, 0));
        Assert.assertEquals(8, fillGrid(5, 5, 3, 3, 3));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int col = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int distance = in.nextInt();
        System.out.println(fillGrid(row, col, x, y, distance));
    }

    public static int fillGrid(int row, int col, int x, int y, int distance) {
        if (distance == 0) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < distance; i++) {
            // right
            int left = x - i;
            int right = y + distance - i;
            if (validation(row, col, left, right)) {
                count++;
            }
            // bottom
            left = x + distance - i;
            right = y - i;
            if (validation(row, col, left, right)) {
                count++;
            }
            // left
            left = x + i;
            right = y - distance + i;
            if (validation(row, col, left, right)) {
                count++;
            }
            left = x - distance + i;
            right = y + i;
            if (validation(row, col, left, right)) {
                count++;
            }
        }
        return count;
    }

    private static boolean validation(int row, int col, int x, int y) {
        return x <= row && x > 0 && y <= col && y > 0;
    }
}
