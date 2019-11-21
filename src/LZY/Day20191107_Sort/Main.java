package LZY.Day20191107_Sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 十大排序算法比较 main函数 测试
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{ 6, 4, 9, 5, 10, 1, 3, 7, 8, 11};
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                //选择排序
                System.out.println(Arrays.toString(ChooseSort.chooseSort(arr)));
                break;
            case 2:
                //插入排序
                System.out.println(Arrays.toString(InsertSort.insertSort(arr)));
                break;
            case 3:
                //冒泡排序
                System.out.println(Arrays.toString(BubbleSort.bubbleSort(arr)));
                break;
            case 4:
                // 快速排序
                System.out.println(Arrays.toString(QuickSort.quickSort(arr)));
                break;
                default:
                    break;
        }
    }
}
