package learn;

/**
 * @author Create by xuantang
 * @date on 9/8/18
 */
public class EqualTest {
    String value;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EqualTest) {
            return value.equals(((EqualTest) obj).value);
        }
        return false;
    }

    public static void main(String[] args) {
        EqualTest equalTest = new EqualTest();

        System.out.println(equalTest.equals(null));
    }
}
