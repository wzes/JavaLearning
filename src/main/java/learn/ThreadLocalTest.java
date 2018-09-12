package learn;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Create by xuantang
 * @date on 8/20/18
 */
public class ThreadLocalTest {
    private static ThreadLocal<String> local = new ThreadLocal<>();

    private static ThreadLocal<String> local2 = new ThreadLocal<>();

    static String name = "Sssss";
    public static void main(String[] args) {
        local.set(name);
        local2.set("2sss");
        System.out.println(local.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                name = "1122";
                local.set(name);
                local2.set("2sub");
                System.out.println(local.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                local.set(name);
                System.out.println(local.get());
            }
        }).start();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
    }
}
