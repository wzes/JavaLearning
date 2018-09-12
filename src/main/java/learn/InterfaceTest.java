package learn;

/**
 * @author Create by xuantang
 * @date on 8/12/18
 */
public interface InterfaceTest {

    default void change() {
        System.out.println("change");
    }
}
