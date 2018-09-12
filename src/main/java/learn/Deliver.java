package learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deliver {

    private static final Point START = new Point(0,0);
    private static int minPath = Integer.MAX_VALUE;

    /**
     * Travel points
     * @param start start point
     * @param points
     * @param sum
     * @param count
     * @return min path
     */
    private int calculate(Point start, List<Point> points, int sum, int count){
        if(count == points.size()) {
            minPath = Math.min(minPath, sum + start.getLength(START));
            return minPath;
        }
        for (Point point : points) {
            if (!point.visited) {
                sum += point.getLength(start);
                if (sum < minPath) {
                    point.visited = true;
                    calculate(point, points, sum, count + 1);
                }
                // re-visit
                sum -= point.getLength(start);
                point.visited = false;
            }
        }
        return minPath;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pointNum = Integer.parseInt(input.nextLine().trim());
        // build
        List<Point> points = new ArrayList<>(pointNum);
        for(int i = 0; i < pointNum; i++) {
            String[] locations = input.nextLine().trim().split(",");
            points.add(new Point(Integer.parseInt(locations[0]),
                    Integer.parseInt(locations[1])));
        }
        // calculate
        Deliver deliver = new Deliver();
        int min = deliver.calculate(START, points, 0, 0);
        System.out.println(min);
    }
}

class Point{
    int px;
    int py;
    boolean visited;

    public Point(int px, int py) {
        this.px = px;
        this.py = py;
        this.visited = false;
    }

    public int getLength(Point p){
        return Math.abs(px - p.px) +
                Math.abs(py - p.py);
    }
}
