package LZY.Day20191107_Sort;


/**
 * 冒泡排序
 * 比较相邻两个数据大小，如果前一个比后一个大则交换位置， 第一轮完成之后，最大的一个数会放到最后一位
 * 某数组长度为10，只需对9个数排序就可以得出结果  即 arr.length-1
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i<arr.length-1; i++) {
            for (int j = 0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    Utils.exchange(arr, i, j);
                }
            }
        }
        return arr;
    }
}
