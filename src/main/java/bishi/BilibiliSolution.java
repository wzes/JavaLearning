package bishi;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Create by xuantang
 * @date on 9/7/18
 */
public class BilibiliSolution {

    @Test
    public void SyntaxErrorTest() {
        Assert.assertTrue(hasSyntaxError("<div id=\"val\"></div>"));
        Assert.assertTrue(hasSyntaxError("<div id=\"val\"></value></div>"));
        Assert.assertTrue(hasSyntaxError("<div id=\"val\" name=\"val\"></value></div>"));
        Assert.assertFalse(hasSyntaxError("<div id=\"val\"name=\"val\"></value></div>"));
        Assert.assertFalse(hasSyntaxError("<div id=\"val\"><value></div>"));
        Assert.assertFalse(hasSyntaxError("<div id=\"val\"><value></div></value>"));
    }

    public boolean hasSyntaxError(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '<') {
                int i1 = s.indexOf('>', i);
                boolean b;
                if (i1 == s.length() - 1) {
                    b = hasKeyValueError(stack, s.substring(i + 1, i1 + 1), true);
                } else {
                    b = hasKeyValueError(stack, s.substring(i + 1, i1 + 1), false);
                }
                if (!b) return false;
                i = i1 + 1;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean hasKeyValueError(Stack<String> node, String s, boolean end) {
        Pattern pattern1 = Pattern.compile("[a-z]*>");
        Pattern pattern2 = Pattern.compile("[a-z<]*?=\"[a-z<]*\"?");
        if (s.charAt(0) == '/') {
            if (!node.isEmpty()) {
                String pop = node.peek();
                if (pop.equals(s.substring(1, s.length() - 1))) {
                    node.pop();
                    return true;
                } else if (end) {
                    return false;
                }
            }
            return pattern1.matcher(s).find();
        } else {
            int i = s.indexOf(' ');
            if (i != -1) {
                node.add(s.substring(0, i));
                int left;
                while (true) {
                    left = i + 1;
                    int i2 = s.indexOf(' ', left);
                    if (i2 != -1) {
                        String tmp = s.substring(left, i2);
                        if (!pattern2.matcher(tmp).find()) {
                            return false;
                        }
                    } else {
                        String tmp = s.substring(left, s.length() - 1);
                        Matcher matcher = pattern2.matcher(tmp);
                        matcher.find();
                        return matcher.end() == tmp.length();
                    }
                    i = i2;
                }
            } else {
                node.add(s.substring(0, s.length() -1));
                Matcher matcher = pattern1.matcher(s);
                matcher.find();
                return matcher.end() == s.length();
            }
        }
    }
}
