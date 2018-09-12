package learn;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Create by xuantang
 * @date on 8/20/18
 */
public class AtomicTest {
    // FIXME: 8/20/18
    private static AtomicInteger nextHashCode =
            new AtomicInteger();
    public static void main(String[] args) {
        System.out.println(nextHashCode.getAndAdd(111));
        System.out.println(nextHashCode.get());

        System.out.println(~1);
        System.out.println(Integer.toBinaryString(12));
    }
}
