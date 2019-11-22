package LY.Day20191121_DataStructure.Day20191122_Stack;

import java.util.Stack;

/**
 * @Auther: liuyang
 * @Date: 2019/11/22 20:22
 * @Description: 栈的基本操作
 */
public class StackDemo {
    public static void main(String[] args) {
        /**
         *
         * 功能描述:
         *
         *          boolean empty()             测试堆栈是否为空。
         *          Object peek( )              查看堆栈顶部的对象，但不从堆栈中移除它。
         *          Object pop( )               移除堆栈顶部的对象，并作为此函数的值返回该对象。
         *          Object push(Object element) 把项压入堆栈顶部。
         *          int search(Object element)  返回对象在堆栈中的位置，以 1 为基数。
         *
         * @param: [args]
         * @return: void
         * @auther: liuyang
         * @date: 2019/11/22 8:28 下午
         */
        Stack<String> stack = new Stack<>();
        stack.push("push1");
        stack.push("push2");
        stack.push("push3");
        System.out.println(stack.pop()); //出栈并返回出栈元素
        System.out.println(stack.peek()); //返回栈顶元素
        System.out.println(stack.firstElement());//输出栈底元素

    }
}
