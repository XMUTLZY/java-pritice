package Day20191107_Sort;

/**
 * 选择排序 原理，选择最小的放在第一位，第二小的放在第二位
 * 比较次数:(N-1)+(N-2)+...+(1)
 * 最坏情况交换次数是N
 * 特点：数据移动次数是最小的
 */
public class ChooseSort {
    public static int[] chooseSort(int[] arr) {

        for (int i = 0; i<arr.length; i++) {
            int minIndex = i;//最小值的数组下标
            for (int j = i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            Utils.exchange(arr, i, minIndex);//找到最小的数组下标后 交换位置
        }
        return arr;
    }
}
