package learn;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Create by xuantang
 * @date on 8/19/18
 */
public class CachedThreadPoolTest {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//
//
//        for (int i = 0; i < 1000; i++) {
//            executorService.submit(new Task(i + ""));
//        }
//        //executorService.shutdown();
//
//        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
//
//        Collections.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });

        CopyOnWriteArrayList<Integer> subscriptions = new CopyOnWriteArrayList<>();

        subscriptions.add(0, 1);
        subscriptions.add(0, 1);
        subscriptions.add(0, 1);
        subscriptions.add(0, 1);

        int insert = 1;
        int size = subscriptions.size();
        for (int i = size; i >= 0; i--) {
            if (i == 0 || insert >= subscriptions.get(i - 1)) {
                subscriptions.add(i, insert);
                System.out.println(i);
                break;
            }
        }
    }


    static class Task implements Runnable {

        String name;

        Task(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("thread: " + this.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
