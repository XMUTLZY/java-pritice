package LZY.Day20191129_NiuKe;

/**
 * @Title:关于++操作符的知识点
 *
 * 当操作数在++右边时，先运算再赋值
 * 当操作数在++左边时，先赋值，再做运算
 */
public class Test2 {
    public static void main(String[] args) {
        int i = 0;
        Test2 test2 = new Test2();
        test2.Count(i);
        i = i++;
        System.out.println(i);
    }
    public void Count(int i) {
        i++;
    }
}
