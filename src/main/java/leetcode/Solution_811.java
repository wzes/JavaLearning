package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author Create by xuantang
 * @date on 9/5/18
 */
public class Solution_811 {

    @Test
    public void DomainTest() {
        Assert.assertEquals(new String[]{"9001 com", "9001 leetcode.com", "9001 discuss.leetcode.com"},
                subdomainVisits(new String[] {"9001 discuss.leetcode.com"}).toArray());
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> domain = new HashMap<>(cpdomains.length);
        for (String cpdomain : cpdomains) {
            String[] info = cpdomain.split(" ");
            int vCount = Integer.parseInt(info[0]);
            String topDomain = info[1].substring(info[1].lastIndexOf(".") + 1);
            String secondDomain = info[1].substring(info[1].indexOf(".") + 1);
            String[] domains;
            if (topDomain.equals(secondDomain)) {
                domains = new String[]{topDomain, info[1]};
            } else {
                domains = new String[]{topDomain, secondDomain, info[1]};
            }
            for (String d: domains) {
                domain.put(d, domain.getOrDefault(d, 0) + vCount);
            }
        }
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : domain.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }
}
