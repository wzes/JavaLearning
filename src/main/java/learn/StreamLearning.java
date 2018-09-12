package learn;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * @author Create by xuantang
 * @date on 7/7/18
 */
public class StreamLearning {
    private static int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};

    public static void main(String[] args) {
        List<long[]> longList = Arrays.stream(matrix).map(e -> {
            LongStream longStream = Arrays.stream(e).mapToLong(i -> i);
            return longStream.toArray();
        }).collect(Collectors.toList());
        longList.forEach(e -> {
            for (long l : e) {
                System.out.println(l);
            }
        });

        Iterator<long[]> iterator = longList.iterator();

        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("4");
        priorityQueue.offer("3");

        Arrays.stream(priorityQueue.toArray()).forEach(System.out::println);
        System.out.println(( -1) >>> 1);


        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        int[] arr = new int[] {1, 2, 3, 4};
        final int[] newArr = arr;
        int[] anoArr = new int[] {3, 4, 5, 6, 5};
        arr = anoArr;
        System.out.println(newArr[3]);
    }
}
