package learn;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest functionTest = new FunctionTest();
        System.out.println(functionTest.compute1(5, i -> i * 2, i -> i * i));//50
        System.out.println(functionTest.compute2(5, i -> i * 2, i -> i * i));//100

        System.out.println(functionTest.compute(4, 5, (a, b) -> a * b, a -> a * 2));
    }

    public int compute1(int i, Function<Integer, Integer> after, Function<Integer, Integer> before) {
        return after.compose(before).apply(i);
    }

    public int compute2(int i, Function<Integer, Integer> before, Function<Integer, Integer> after) {
        return before.andThen(after).apply(i);
    }

    public int compute(int a, int b, BiFunction<Integer, Integer, Integer> biFunction,
                       Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(a, b);
    }
}
