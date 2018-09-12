package learn;

/**
 * @author Create by xuantang
 * @date on 8/22/18
 */
public class ByteTest {
    public static void main(String[] args) {

        int flags = 0x00000004;

        int mViewFlags = 0x000000000;
        int mask = 0x0000000C;
        int old = mViewFlags;
        mViewFlags = (mViewFlags & ~mask) | (flags & mask);

        int changed = mViewFlags ^ old;
        System.out.println(changed);

        System.out.println(Integer.toBinaryString(-1));
    }
}
