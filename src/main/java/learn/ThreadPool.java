package learn;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Create by xuantang
 * @date on 8/29/18
 */
public class ThreadPool {
    private int corePoolSize = Runtime.getRuntime().availableProcessors() == 0 ? 3 : Runtime.getRuntime().availableProcessors();
    private AtomicInteger atomicInteger = new AtomicInteger();
    private ThreadFactory mFactory = r -> new Thread(r,"Crawler thread - " + atomicInteger.getAndIncrement());
    ExecutorService mDefaultPool = new ThreadPoolExecutor(corePoolSize * 2, corePoolSize * 4 + 1,
            60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100), mFactory);

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        System.out.println(threadPool.corePoolSize);
        threadPool.mDefaultPool.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
