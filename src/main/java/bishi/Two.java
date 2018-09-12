package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Create by xuantang
 * @date on 9/4/18
 */
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int des = s.indexOf("@");
        String destination = s.substring(0, des);
        int index = des + 1;
        List<Integer> tags = new ArrayList<>();
        int inner = 0;
        boolean suc = true;
        for (int i = 0; i < destination.length(); i++) {
            if ((index = s.indexOf(destination.charAt(inner), index)) != -1) {
                tags.add(index - des - 1);
                inner++;
            } else {
                suc = false;
                break;
            }
        }
        char[] chars = new char[s.length() - destination.length()];
        for (int i = 0; i < s.length() - destination.length() - 1; i++) {
            chars[i] = '0';
        }
        if (suc) {
            for (int c : tags) {
                chars[c] = '1';
            }
        }
        // 0000000000000000000011010000010000000000000000
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
