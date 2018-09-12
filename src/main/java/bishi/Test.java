package bishi;

import java.util.ArrayList;

/**
 * @author Create by xuantang
 * @date on 9/9/18
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Test2.a);
    }

}
class Test2 {
    public static final String a = "JD";

    static {
        System.out.print("OK");
    }
}