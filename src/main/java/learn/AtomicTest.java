package learn;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.currentTimeMillis;

/**
 * @author Create by xuantang
 * @date on 8/20/18
 */
public class AtomicTest {
    // FIXME: 8/20/18
    private static AtomicInteger nextHashCode =
            new AtomicInteger();
    public static void main(String[] args) {
        System.out.println(nextHashCode.getAndAdd(111));
        System.out.println(nextHashCode.get());

        System.out.println(~1);
        System.out.println(Integer.toBinaryString(12));

        StringBuffer stringBuffer = new StringBuffer();

        Timestamp ts = new Timestamp(currentTimeMillis());
        String tsStr = "";
        DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            //方法一
            tsStr = sdf.format(ts);
            System.out.println(tsStr);
            //方法
            tsStr = ts.toString().substring(11, 19);
            System.out.println(tsStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Character.isLetter(1001));


        String[] tmp = ("%。.，,、：:@；;+#？?“”\"‘’'！!~~′`**（）()&^$【】[]{}{}《》<>\\|/-_+=×√￥ˉ﹍-￣─│┅┇·┈┊←※━┃『』〖〗〔〕「」︵︷︿︹︽_︶︸﹀︺︾﹂﹄︼︻﹁﹃□→‖﹎︴々☉⊙◎♂♀◇の★☆→あぃ￡Ю∴∷﹌§¤≈÷↑↓Σ卐┄┆￠€￡Ω∞⊕Θ㊣①②③④⑤⑥⑦⑧⑨⑩ⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩ一二三四五六七八九十㈠㈡㈢㈣㈤㈥㈦㈧㈨〓┱┲╬『』▄█▌·●○◆◣◢◥▲▼△▽⊿◤o■□▂▃▅▆▇▉▊▋▍▎▏℃￠￡￥¤℉‰€㏄㎜㎝㎞㎡㎎㎏°").split("");
        for (int i = 0; i < tmp.length; i++) {
            // 中文 charValue >= 33 && charValue <= 126 || charValue == 32
            if (tmp[i].charAt(0) >= 33 && tmp[i].charAt(0) <= 126 || tmp[i].charAt(0) == 32) {
                System.out.println(tmp[i] + " 全角" + i);
            } else {
                System.out.println(tmp[i] + " 半角" + i);
            }
        }
    }
}
