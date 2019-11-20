package LZY.Day20191107_Sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i<arr.length; i++) {
            for (int j = i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    Utils.exchange(arr, i, j);
                }
            }
        }
        return arr;
    }
}
