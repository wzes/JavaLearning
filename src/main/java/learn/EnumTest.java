package learn;

import java.util.Collections;

/**
 * @author Create by xuantang
 * @date on 8/13/18
 */
public enum EnumTest {
    INSTANCE;

    public String getString() {
        return "Enum";
    }

    public static void main(String[] args) {
        String string = EnumTest.INSTANCE.getString();
        Collections.singleton("d");
        System.out.println(string);
    }
}
