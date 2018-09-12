package learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 7/4/18
 */
public class RuntimeConstantOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        try {
            while (true) {
                list.add(String.valueOf(i++).intern());
            }
        } catch (Error e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
