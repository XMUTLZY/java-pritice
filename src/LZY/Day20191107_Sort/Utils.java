package LZY.Day20191107_Sort;

/**
 * 工具类
 */
public class Utils {
    public static void exchange(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
