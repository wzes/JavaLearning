package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Create by xuantang
 * @date on 9/4/18
 */
public class Solution_593 {

    @Test
    public void ValidTest() {
        Assert.assertTrue(validSquare(new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}));
        Assert.assertTrue(validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1 == null || p2 == null || p3 == null || p4 == null)
            return false;
        if (p1.length != 2 || p2.length != 2 || p3.length != 2 || p4.length != 2)
            return false;
        int[][] points = {p1, p2, p3, p4};
        double edge = 0;
        double diagonal = 0;
        for (int i = 0; i < points.length; i++){
            for (int j = i + 1; j < points.length; j++){
                double length = lengthOf(points[i], points[j]);
                if (length == 0) return false;
                if (edge == 0){
                    edge = length;
                }
                if (diagonal == 0 && length != edge){
                    diagonal = length;
                }
                if (length != edge && length != diagonal){
                    return false;
                }
            }
        }
        return true;
    }

    private static double lengthOf(int[] a, int[] b){
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
}
