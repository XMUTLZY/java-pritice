package LZY.Day20191213_JAVA8.MethodReferences;

import java.util.Arrays;
import java.util.List;

/**
 * 方法引用
 */
public class MethodReferences {
    public static void main(String[] args) {
        //1、循环输出
        List<String> names = Arrays.asList("Li", "Chen", "Ruan", "Liu");
        names.forEach(System.out::println);
        Person person = Person.create(Person::new);
    }
}

@FunctionalInterface
interface Supplier<T> {
    T get();
}

class Person {
    public static Person create(Supplier<Person> supplier) {
        return supplier.get();
    }

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}