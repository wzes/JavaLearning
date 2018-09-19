package learn;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, InterruptedException {
        read();

        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        InnerThread innerThread = new InnerThread(unsafe);
        innerThread.run();

        //Thread.sleep(2000);
        // 取消挂起
        unsafe.unpark(innerThread);
    }

    static class InnerThread extends Thread {
        Unsafe unsafe;

        InnerThread(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        @Override
        public void run() {
            System.out.println("start");
            unsafe.park(false, 1000000000);
            System.out.println("end");
        }
    }

    static class InnerClass {
        private volatile long value;
        InnerClass() {
            value = 100L;
        }
        void print() {
            System.err.println("value==>" + value);
        }
    }

    private static void read() throws NoSuchFieldException, IllegalAccessException {

        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        String str = "Hello Unsafe";
        Field value = str.getClass().getDeclaredField("value");

        value.setAccessible(true);
        value.set(str, new char[] {'f', 'i', 'n', 'a', 'l'});
        System.out.println(str);
        unsafe.putObject(str, unsafe.objectFieldOffset(value), new char[]{'M', 'a', 'j', 'i', 'c'});
        System.out.println(str);
    }

    public void cas() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
        new InnerClass().print();
        InnerClass o = (InnerClass)unsafe.allocateInstance(InnerClass.class);
        o.print(); // print 100
        Field a = o.getClass().getDeclaredField("value");
        unsafe.putLong(o, unsafe.objectFieldOffset(a), 10000);
        o.print(); // print 10000
        unsafe.compareAndSwapLong(o, unsafe.objectFieldOffset(a), 10000, 1111);
        o.print(); // print 1111
        unsafe.compareAndSwapLong(o, unsafe.objectFieldOffset(a), 1000, 10000);
        o.print(); // print 1111
    }
}