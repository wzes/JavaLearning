package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DoubleSortTest {

    public static void main(String[] args) {

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(12.2);
        doubleList.add(1.2);
        doubleList.add(-1.2);
        Collections.sort(doubleList, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o1, o2);
            }
        });
        doubleList.forEach(System.out::println);
    }
}
