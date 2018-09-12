package learn;

/**
 * @author Create by xuantang
 * @date on 8/12/18
 */
public class StringTest {
    public static void main(String[] args) {
        //String a = "abc";
//        String b = new String("abc");
//        String c = new String("abc");
//        System.out.println(a == b.intern());
//        System.out.println(b == c);

        String a = "abc";
        String b = new String("abc");
        System.out.println(a == b.intern());
        String d = new StringBuilder("a").append("b").append("c").toString();
        System.out.println(d.intern() == d);

        String java = new StringBuilder().append("ja").append("va").toString();
        System.out.println(java.intern() == java);

        String s1 = new String("A") + new String("A");
        System.out.println(s1);     //AA
        String s2 = s1.intern();    //此时s1=s2
        String s3 = "AA";
        System.out.println(s2==s3); //true
        System.out.println(s1==s3); //true
    }
}
