package learn;

import java.util.HashMap;

/**
 * @author Create by xuantang
 * @date on 8/21/18
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<HashMapTest, String> map = new HashMap<>();


        for (int i = 0; i < 100; i++) {
            map.put(new HashMapTest(), "ssss");
        }

        System.out.println(System.identityHashCode(new String("Ss")));
        System.out.println(System.identityHashCode(new String("ss")));
    }

    @Override
    public int hashCode() {
        return 100;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
