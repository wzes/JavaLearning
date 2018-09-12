package jd;

/**
 * @author Create by xuantang
 * @date on 9/9/18
 */
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int Solve(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                boolean b = true;
                for (int k = 0; k <= j; k++) {
                    if (a[k] > a[i] && a[k] > a[j]) {
                        b = false;
                        break;
                    }
                }
                if (b) count++;
            }
        }
        return count;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        res = Solve(_a);
        System.out.println(String.valueOf(res));

    }
}
