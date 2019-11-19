package Day20191107_Sort;

import java.util.Arrays;

/**
 * 十大排序算法比较 main函数
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{ 6, 4, 9, 5, 10, 1, 3, 7, 8, 2};
        //选择排序
        System.out.println(Arrays.toString(ChooseSort.chooseSort(arr)));
        //插入排序
        System.out.println(Arrays.toString(InsertSort.insertSort(arr)));
        //冒泡排序
        System.out.println(Arrays.toString(BubbleSort.bubbleSort(arr)));
    }
}
