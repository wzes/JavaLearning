package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Solution_537 {
    @Test
    public void Test() {
        Assert.assertEquals("0+2i", complexNumberMultiply("1+1i", "1+1i"));
        Assert.assertEquals("0+-2i", complexNumberMultiply("1+-1i", "1+-1i"));
        Assert.assertEquals("0+0i", complexNumberMultiply("1+-1i", "0+0i"));
        Assert.assertEquals("1+0i", complexNumberMultiply("1+0i", "1+0i"));
    }

    public String complexNumberMultiply(String a, String b) {
        int aa = Integer.parseInt(a.substring(0, a.indexOf('+')));
        int ab = Integer.parseInt(a.substring(a.indexOf('+') + 1, a.lastIndexOf('i')));
        int ba = Integer.parseInt(b.substring(0, b.indexOf('+')));
        int bb = Integer.parseInt(b.substring(b.indexOf('+') + 1, b.lastIndexOf('i')));
        return (aa * ba - ab * bb) + "+" + (aa * bb + ab * ba) + "i";
    }
}
