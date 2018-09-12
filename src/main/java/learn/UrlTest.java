package learn;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Create by xuantang
 * @date on 8/20/18
 */
public class UrlTest {


    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");
            System.out.println(url.getHost());

            URL url1 = new URL("https://blog.csdn.net/valada/article/details/81639702");
            System.out.println(url1.getHost());

            String domainName = getDomainName(url);

            System.out.println(domainName);

            String domainName1 = getDomainName(url1);

            System.out.println(domainName1);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private final static Set<String> PublicSuffixSet = new HashSet<>(
            Arrays.asList("com|org|net|gov|edu|co|tv|mobi|info|asia|xxx|onion|cn|com.cn|edu.cn|gov.cn|net.cn|org.cn|jp|kr|tw|com.hk|hk|com.hk|org.hk|se|com.se|org.se"
                    .split("\\|")));

    private static Pattern IP_PATTERN = Pattern
            .compile("(\\d{1,3}\\.){3}(\\d{1,3})");

    /**
     * 获取url的顶级域名
     * @param url
     * @return
     */
    private static String getDomainName(URL url) {
        String host = url.getHost();
        if (host.endsWith(".")) {
            host = host.substring(0, host.length() - 1);
        }
        if (IP_PATTERN.matcher(host).matches()) {
            return host;
        }
        int index = 0;
        String candidate = host;
        for (; index >= 0;) {
            index = candidate.indexOf('.');
            String subCandidate = candidate.substring(index + 1);
            if (PublicSuffixSet.contains(subCandidate)) {
                return candidate;
            }
            candidate = subCandidate;
        }
        return candidate;
    }

    /**
     * 获取url的顶级域名
     * @param url
     * @return
     * @throws MalformedURLException
     */
    public static String getDomainName(String url) throws MalformedURLException {
        return getDomainName(new URL(url));
    }


}
