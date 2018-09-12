package benchmark;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * @author Create by xuantang
 * @date on 8/23/18
 */
public class BenchmarkTest {


    @Benchmark
    public void testMethod() {
        // This is a demo/sample template for building your JMH benchmarks. Edit as needed.
        // Put your benchmark code here.

        int a = 1;
        int b = 2;
        int sum = a + b;
    }
}
