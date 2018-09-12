package learn;

import javafx.scene.AmbientLight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Create by xuantang
 * @date on 9/7/18
 */
public class Scala<T> {


    public void apply(List<? super T> content) {

    }

    class Animal {
        String name;
    }

    class Dog extends Animal {

        void rename(String name) {
            super.name = name;
        }
    }
}
