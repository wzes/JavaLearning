package learn;

import bishi.MurmurHash;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.Executors;

import static java.lang.Math.max;

/**
 * @author Create by xuantang
 * @date on 7/20/18
 */
public class Test {
    private int i = 5;

    public int inc() {
        return i + 1;
    }

    static ReferenceQueue referenceQueue = new ReferenceQueue();

    public static void main(String[] args) {

        int log2m = 29;
        int hashedValue = MurmurHash.hash("122sas12s3ss");
        int r = (hashedValue << log2m) | (1 << (log2m - 1)) + 1;
        System.out.println(r);

        System.out.println(~1);
        System.out.println(Long.numberOfLeadingZeros(r) + 1);


        System.out.println(-1 >>> 1);
//
//        Scala<Scala.Dog> scala = new Scala<>();
//
//        List<Scala.Animal> dogs = new ArrayList<>();
//        scala.apply(dogs);
//
//        StringBuilder sb = new StringBuilder("12345");
//        System.out.println(sb.delete(sb.length() - 1, sb.length()).toString());
//
//        System.out.println(lcs("abcdf", "bdf"));
//
//        System.out.println(lcs1("avbcdf", "abdf"));
//
//        System.out.println(replaceSpace(new StringBuffer("We are happy")));
//        Thread thread = new Thread(() -> {
//            try {
//                System.out.println("started");
//                int cnt = 0;
//                WeakReference<byte[]> k;
//                while((k = (WeakReference) referenceQueue.remove(10000)) != null) {
//                    System.out.println((cnt++) + "回收了:" + k);
//                }
//                System.out.println("over");
//            } catch(Exception e) {
//                //结束循环
//                System.out.println("2222222222");
//            }
//        });
//
//        thread.setDaemon(true);
//        thread.start();
//        Object value = new Object();
//        WeakHashMap<Object, Object> map = new WeakHashMap<>();
//        for(int i = 0;i < 1000; i++) {
//            byte[] bytes = new byte[1 << 25];
//            //System.out.println(i);
//            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, referenceQueue);
//            map.put(weakReference, value);
//        }
//        System.out.println("map.size->" + map.size());
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        Hashtable<String, StreamLearning> hashtable = new Hashtable<>();

    }

    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int result = 0;
        //记录最长公共子串长度
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    result = max(c[i][j], result);
                } else {
                    c[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static int lcs1(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else {
                    c[i][j] = max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }

    /**
     *
     * @param str We are happy to We%20are%happy
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int index = 0;
        while (index < length) {
            if (str.charAt(index) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(index));
            }
            index++;
        }
        return sb.toString();
    }

    public static boolean Find(int target, int [][] array) {

        int row = array.length;
        int col = array[0].length;

        return false;
    }



}
