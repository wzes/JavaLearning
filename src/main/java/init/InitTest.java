package init;

/**
 * @author Create by xuantang
 * @date on 9/9/18
 */
public class InitTest {
    public static int value = 123;
    static {
        System.out.println("Super init");
    }
}
