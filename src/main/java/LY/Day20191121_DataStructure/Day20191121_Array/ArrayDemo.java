package LY.Day20191121_DataStructure.Day20191121_Array;

/**
 * @Auther: liuyang
 * @Date: 2019/11/21 16:10
 * @Description:数组使用
 */
public class ArrayDemo {
    public static void main(String[] args) {

        /**
         * 基本数据类型的
         *             整数类型（byte、short、int、long）默认值是0；
         *
         *             基本数据类型的浮点类型（float、double）默认值是0.0；
         *
         *             基本数据类型的字符类型（char）默认值是'\u0000'；
         *
         *             基本数据类型的布尔类型（boolean）默认值是false；
         *
         *             类型的引用类型（类、数组、接口、String）默认值是null.
         *
         * JVM类加载机制：类的加载、连接、初始化   基本数据类型赋默认值是在类的"连接"阶段中的"准备"阶段   初始化阶段完成具体值的赋值
         * 例如：某个类变量定义为public static int x = 1; 程序在"准备"被赋为0,在初始化阶段完成x = 1的赋值
         */

        /**
         * 动态初始化:初始化时由程序员指定数组的长度，由系统初始化每个数组元素的默认值。
         */
        int a[] = new int[4];


        /**
         * 静态初始化:初始化时由程序员显式指定每个数组元素的初始值,由系统决定数组的长度；
         */
        int b[] = new int[]{1,2,3,4};


        /**
         * 简化版静态初始化
         */
        int c[] = {1,2,3,4};

        /**
         * 二维数组
         */
        int d[][] = new int[4][4];
        int []e[] = new int[2][];
        int [][]f = new int[2][];
        int [][]g = {{1,2},{1,2}};

    }
}
