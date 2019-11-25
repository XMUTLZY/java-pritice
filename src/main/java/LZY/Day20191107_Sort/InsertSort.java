package LZY.Day20191107_Sort;

/**
 * 插入排序  假设前n-1个数已经排好序，将第n个数插入到指定位置，以此类推
 */
public class InsertSort {
    public static int[] insertSort(int[] arr) {
        for (int i = 1; i<arr.length; i++) {
            for (int j = i-1; j>0; j--) {
                if (arr[i] < arr[j])
                    Utils.exchange(arr, i, j);
            }
        }
        return arr;
    }
}
