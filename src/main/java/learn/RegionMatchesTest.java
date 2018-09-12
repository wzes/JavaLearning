package learn;

/**
 * @author Create by xuantang
 * @date on 8/13/18
 */
public class RegionMatchesTest {
    public static void main(String[] args) {
        String source = "abcdefg";

        System.out.println(source.regionMatches(0, "abc", 8, 3));
    }
}
