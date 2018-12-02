package learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Create by xuantang
 * @date on 8/14/18
 */
public class BlockingQueueTest {

    public static void main(String[] args) {
//        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                queue.offer("Ssssssssss");
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String take = null;
//                try {
//                    take = queue.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(take);
//            }
//        }).start();
//
//        BlockingQueueTest test = new BlockingQueueTest();
//        test.print();

        List<String> aaaa = TestTest.getInstance("aaaa");

        aaaa.forEach(System.out::println);
    }

    void print() {
        System.out.println("private");
    }
}

class TestTest {


    private void test() {
        BlockingQueueTest test = new BlockingQueueTest();
        test.print();
    }

    static <T> List<T> getInstance(T object) {
        return Arrays.asList(object, object);
    }
}
