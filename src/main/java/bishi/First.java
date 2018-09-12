package bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Create by xuantang
 * @date on 9/4/18
 */
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(binaryAdd(s));
    }

    private static String binaryAdd(String s) {
        String[] nums = s.split("\\W+");
        String num1, num2;
        if (nums[0].length() > nums[1].length()) {
            num1 = nums[0];
            num2 = nums[1];
        } else {
            num1 = nums[1];
            num2 = nums[0];
        }
        int i2 = num2.length() - 1;
        int i1 = num1.length() - 1;
        int i = 0;
        boolean pop = false;
        List<Character> sum = new ArrayList<>();
        while (i <= i2) {
            if (num1.charAt(i1 - i) == '1' && num2.charAt(i2 - i) == '1') {
                if (pop) {
                    sum.add('1');
                } else {
                    sum.add('0');
                }
                pop = true;
            } else if (num1.charAt(i1 - i) != '1' && num2.charAt(i2 - i) != '1') {
                if (pop) {
                    sum.add('1');
                } else {
                    sum.add('0');
                }
                pop = false;
            } else {
                if (pop) {
                    sum.add('0');
                } else {
                    sum.add('1');
                }
            }
            i++;
        }
        while (i <= i1) {
            if (pop) {
                if (num1.charAt(i1 - i) == '1') {
                    sum.add('0');
                } else {
                    sum.add('1');
                    pop = false;
                }
            } else {
                sum.add(num1.charAt(i1 - i));
            }
            i++;
        }
        if (pop) sum.add('1');
        StringBuilder sb = new StringBuilder();
        for (i = sum.size() - 1; i >= 0; i--) {
            sb.append(sum.get(i));
        }
        String res = sb.toString();
        for (i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0') {
                break;
            }
        }
        return res.substring(i);
    }
}
