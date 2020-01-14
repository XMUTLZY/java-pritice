package LZY.Day20191213_JAVA8.DefaultMethod;

/**
 * @Title: Java8新特性——扩展方法
 * 允许接口有默认实现方法，其实现类不一定要实现或重写该默认方法
 */
public class DefaultMethod {
    public static void main(String[] args) {
        Boy boy = new Boy();
        boy.run();
        boy.eat();
        boy.say();
        Girl girl = new Girl();
        girl.eat();
        girl.run();
        girl.say();
    }
}

interface Person {
    void run();
    void eat();
    default void say() { /** 使用default关键字修饰 */
        System.out.println("people say");
    }
}

class Boy implements Person { /** Boy类不实现扩展方法 */
    @Override
    public void run() {
        System.out.println("boy run");
    }

    @Override
    public void eat() {
        System.out.println("boy eat");
    }
}

class Girl implements Person { /** Girl类实现扩展方法，并重写 */
    @Override
    public void run() {
        System.out.println("girl run");
    }

    @Override
    public void eat() {
        System.out.println("girl eat");
    }

    @Override
    public void say() {
        System.out.println("girl say");
    }
}