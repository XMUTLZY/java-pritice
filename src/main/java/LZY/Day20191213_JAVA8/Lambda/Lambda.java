package LZY.Day20191213_JAVA8.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Lambda表达式常用语法
 */
public class Lambda {
    public static void main(String[] args) {
        //1、排序
        List<String> names = Arrays.asList("Li", "Chen", "Ruan", "Liu");
        //(1)Collections.sort(names, Comparator.reverseOrder());
        //(2)Collections.sort(names, (a, b)->b.compareTo(a));
        Collections.sort(names, Comparator.naturalOrder());
    }
}

