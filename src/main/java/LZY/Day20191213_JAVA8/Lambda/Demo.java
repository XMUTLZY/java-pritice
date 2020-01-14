package LZY.Day20191213_JAVA8.Lambda;

/**
 * Lambda表达式Demo
 * 加减乘除运算
 */
public class Demo {
    public static void main(String[] args) {
        //函数声明
        MathOperate addOperate = (a, b) -> a + b;
        MathOperate subOperate = (a, b) -> a - b;
        MathOperate multiOperate = (a, b) -> a * b;
        MathOperate diviOperate = (a, b) -> a / b;
        PrintInterface printInterface = message -> System.out.println(message);
        printInterface.print("10 + 5 = " + operate(10, 5, addOperate));
        printInterface.print("10 - 5 = " + operate(10, 5, subOperate));
        printInterface.print("10 * 5 = " + operate(10, 5, multiOperate));
        printInterface.print("10 / 5 = " + operate(10, 5, diviOperate));
    }

    //定义方法，传入具体的函数
    private static int operate(int a, int b, MathOperate mathOperate) {
        return mathOperate.operate(a, b);
    }

    /**
     * 定义函数接口
     */
    @FunctionalInterface
    interface MathOperate {
        int operate(int a, int b);// a,b运算函数
    }

    @FunctionalInterface
    interface PrintInterface {
        void print(String message);
    }

}


