package LZY.Day20191213_JAVA8.Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Stream 处理  Demo
 *
 * @Define: filter():通过设置的条件过滤出符合条件的元素
 *          map():用于映射每个元素到对应的结果
 *          flatMap():将流中的每一个元素T映射为一个流，再把每一个流连接成为一个流
 *          limit():用于获取指定数量的流
 *          distinct():去重
 *          sorted():对流进行排序
 *          boxed(): 用于将数值流转换为流
 *
 *
 */
public class Demo {
    public static void main(String[] args) {
        //声明
        List<String> stringList = Arrays.asList("a", "", "b", "c", "d", "f");
        List<Integer> integerList = Arrays.asList(1, 5, 3, 2, 4, 3);
        //过滤空字符串
        List<String> filterEmptyStringList = stringList.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("过滤空字符串之后:" + filterEmptyStringList + ",长度为" + filterEmptyStringList.size());
        //合并字符串
        String mergeString = filterEmptyStringList.stream().collect(Collectors.joining());
        System.out.println("合并过滤之后的字符串:" + mergeString);
        //对整型数组分别求平方
        List<Integer> sqareIntegerList = integerList.stream().map(integer -> integer*integer).collect(Collectors.toList());
        System.out.println("对整型数组求平方之后:" + sqareIntegerList);
        //对整型数组去重并从大到小排序
        List<Integer> uniqReSort = integerList.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("对整型数组去重并从大到小排序之后：" + uniqReSort);
        //生成10个随机数排序
        Random random = new Random();
        random.ints(10, 100).limit(10).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(System.out::println);
        //flatMap用法
        List<String> strList = Arrays.asList("aaa bbb ccc", "ddd eee fff", "ggg hhh iii");
        strList.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).forEach(System.out::println);
        //anyMatch用法
        if (integerList.stream().anyMatch(integer -> integer == 2)) {
            System.out.println("整型数组中存在2");
        }
        /**
         * 数值流操作
         */
        //转换为数值流 mapToInt()
        int sum = integerList.stream().mapToInt(Integer::intValue).sum();
        OptionalInt max = integerList.stream().mapToInt(Integer::intValue).max();
        OptionalInt min = integerList.stream().mapToInt(Integer::intValue).min();
        System.out.println("和为:" + sum + ";最大值为:" + max + ";最小值为:" + min);
    }
}
