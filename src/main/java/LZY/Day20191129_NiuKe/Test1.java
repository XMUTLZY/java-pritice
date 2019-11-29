package LZY.Day20191129_NiuKe;

/**
 * @判断程序输出
 */
public class Test1 {
    public static void main(String[] args) {
        Car aodi = new Aodi();
        aodi.run();
        System.out.println(aodi.getClass().getName());
        Aodi newAodi = (Aodi) aodi;//对象引用不变
        newAodi.stop();
        System.out.println(aodi);
        System.out.println(newAodi);
    }
}

interface Car {
    void run();
}

class Aodi implements Car {
    @Override
    public void run() {
        System.out.println("aodi run run run");
    }
    public void stop() {
        System.out.println("aodi stop stop stop");
    }
}