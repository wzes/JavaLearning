package learn;

/**
 * @author Create by xuantang
 * @date on 8/14/18
 */
public class ElementsTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};

        int[] clone = arr.clone();
        arr[0] = 4;

        System.out.println(clone[0]);
    }
}
