package LZY.Day20191107_Sort;

/**
 * 快速排序思想 (未完成)
 *
 */
public class QuickSort {
    public static int[] quickSort(int[] arr) {
        sort(arr, 0, arr.length-1);
        return arr;
    }
    private static void sort(int[] a, int low, int high) {
        int key = a[low];//基准值
        int start = low;
        int end = high;
        while (start<end) {
            while (a[end] > key && start<end) {
                end--;//找到第一个比基准值小的数的索引
            }
            Utils.exchange(a, start, end);
            while (a[start] > key && start<end) {
                start++;
            }
            Utils.exchange(a, start, end);
        }
    }
}
