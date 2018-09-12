package learn;

/**
 * @author Create by xuantang
 * @date on 8/10/18
 */
public class InitializeTest {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        Class.forName("learn.ClassTypeTest");


        ClassTypeTest classTypeTest = new ClassTypeTest();
        ClassTypeTest classTypeTest1 = new ClassTypeTest();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                classTypeTest.test5();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                classTypeTest.test6();
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                classTypeTest.test4();
            }
        });
        thread4.start();
        thread.start();
        Thread.sleep(1200);
        thread2.start();
        thread.join();
        thread2.join();
        thread4.join();
    }
}
