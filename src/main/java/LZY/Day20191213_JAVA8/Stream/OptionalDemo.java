package LZY.Day20191213_JAVA8.Stream;

import java.util.Optional;

/**
 * Optional 用法
 * of():当传入参数为null时，程序会保存NullPointerException
 * ofNullable():当传入参数为null返回orElse()内的数据
 * orElse()和orElseGet()的区别：当ofNullable()执行时，orElse()会执行，orElseGet()不会执行
 */
public class OptionalDemo {
    public static void main(String[] args) {
        User user1 = new User("Lin");
        User user2 = null;
//        User result = Optional.of(user2).orElse(user1);
        User result = Optional.ofNullable(user1).orElse(createUser());
        System.out.println(result.toString());
        User result2 = Optional.ofNullable(user1).orElseGet(OptionalDemo::createUser);
        System.out.println(result2.toString());
    }
    private static User createUser() {
        System.out.println("1");
        return new User("Chen");
    }
}


class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}