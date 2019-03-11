package leetcode;

import org.junit.Assert;
import org.junit.Test;
import java.util.Stack;

public class Solution_155 {

    @Test
    public void Test() {

        MinStack obj = new MinStack();
        obj.push(3);
        int param_3 = obj.top();
        obj.push(1);
        int param_4 = obj.getMin();
        obj.pop();
        int param_5 = obj.getMin();
        Assert.assertEquals(3, param_3);
        Assert.assertEquals(1, param_4);
        Assert.assertEquals(3, param_5);
    }

    class MinStack {

        Stack<Integer> mStack, mMinStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            mStack = new Stack<>();
            mMinStack = new Stack<>();
        }

        public void push(int x) {
            mStack.push(x);
            if (mMinStack.empty() || x < mMinStack.peek()) {
                mMinStack.push(x);
            } else {
                mMinStack.push(mMinStack.peek());
            }
        }

        public void pop() {
            mStack.pop();
            mMinStack.pop();
        }

        public int top() {
            return mStack.peek();
        }

        public int getMin() {
            return mMinStack.peek();
        }
    }
}
