package learn;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Create by xuantang
 * @date on 8/21/18
 */
public class RefTest {
    private static ReferenceQueue<byte[]> rq = new ReferenceQueue<byte[]>();
    private static int _1M = 1024*1024;

    public static void main(String[] args) {
        Object value = new Object();
        Map<Object, Object> map = new HashMap<>();
        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                SoftReference<byte[]> k;
                while((k = (SoftReference) rq.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k);
                }
            } catch(InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();

        // 1024mb 4/5 816mb 幸存区，满了会造成minor GC，会回收幸存区
        for(int i = 0; i < 820; i++) {
            byte[] bytes = new byte[_1M];
            SoftReference<byte[]> weakReference = new SoftReference<byte[]>(bytes, rq);
            map.put(new Object(), weakReference);
        }
        System.out.println("map.size->" + map.size());
    }
}
