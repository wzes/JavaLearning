package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author Create by xuantang
 * @date on 9/4/18
 */
public class Solution_856 {

    @Test
    public void ParentTest() {
        Assert.assertEquals(2, scoreOfParentheses("()()"));
        Assert.assertEquals(2, scoreOfParentheses("(())"));
        Assert.assertEquals(4, scoreOfParentheses("((()))"));
        Assert.assertEquals(6, scoreOfParentheses("(()(()))"));
        Assert.assertEquals(4, scoreOfParentheses("(()())"));
        Assert.assertEquals(3, scoreOfParentheses("()(())"));

        System.out.println((1 & 11) == 0);
    }


    public int rec(String S) {
        int cnt = 0, res = 0;
        char last = ' ';
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                cnt++;
            } else {
                cnt--;
                if (last == '(') {
                    res += 1 << cnt;
                }
            }
            last = ch;
        }
        return res;
    }

    public int scoreOfParentheses(String S) {
        if (S.equals("()")) return 1;
        int count = 0;
        for (int i=0; i<S.length(); i++) {
            if (S.charAt(i)=='(') {
                count ++;
            } else {
                count --;
                if (count==0) {
                    if (i==S.length()-1)
                        return 2*scoreOfParentheses(S.substring(1, S.length()-1));
                    else
                        return scoreOfParentheses(S.substring(0, i+1))+scoreOfParentheses(S.substring(i+1));
                }
            }
        }
        return 0;
    }
}
