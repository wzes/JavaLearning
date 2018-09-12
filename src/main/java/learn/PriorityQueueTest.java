package learn;

import java.util.PriorityQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author Create by xuantang
 * @date on 8/10/18
 */
public class PriorityQueueTest {

    public static void main(String[] args) {


        PriorityQueue<String> queue = new PriorityQueue<>();

        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        synchronousQueue.add("abc");
    }

}
