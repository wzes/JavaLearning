package learn;

/**
 * @author Create by xuantang
 * @date on 8/9/18
 */
public class MyThread extends Thread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.start();

        myThread.interrupt();

        myThread.stop();
    }


    @Override
    public void run() {
        while (true) {
            int a = 1;
        }
    }
}
