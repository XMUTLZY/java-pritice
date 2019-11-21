package LZY.Day20191121_JavaBase.Exception;

/**
 * 异常概念
 *
 * Throwable是异常(Exception)和错误(Error)的超类  Throwable类位于java.lang;包下
 *
 * 异常(Exception)又分为   运行时异常(RunTimeException)/非受检异常  和  检查异常(CheckedException)/受检异常
 * 运行异常：NullPointerExcetion、IndexOutOfBoundsExcetion...
 * 检查异常：IOException、SqlException....程序运行时必须被捕获的异常 使用try catch  或 throws关键字
 *
 * 错误(Error)这里不详细介绍, 最典型的错误就是OutOfMemoryError(内存溢出),在jvm底层会经常见到
 */
public class ExceptionClass {
    public static void main(String[] args) {
        /**
         *  这里主要介绍下检查异常时的捕获方式try catch和需要注意到的点
         */
        try {
            /**
             * try内部执行可能发生受检异常的语句
             */
        } catch (Exception e) {
            /**
             *  如果捕获到对应的异常类型，则执行catch块内部的语句
             *  注:一个try至少有一个catch
             */
        } finally {
            /**
             * 可有可无，无论是否捕获到异常，都会执行finally内部的语句
             * 如果catch 语句中有return 则也会先执行finally再return
             */
        }
    }
}
