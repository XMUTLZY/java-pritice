package LY.Day20191121_Algorithm.Day20191121_QuickSort;

import java.util.Arrays;

/**
 * @Auther: liuyang
 * @Date: 2019/11/21 13:13
 * @Description:快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 1, 2, 77, 44, 66, 73, 345, 34, 14, 3};
        new QuickSortForTwoWay().QuickSortByTwoWay(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = new int[]{5, 1, 2, 77, 44, 66, 73, 345, 34, 14, 3};
        new QuickSortForOneWay().QuickSortByOneWay(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }
}

class QuickSortForTwoWay {
    public void QuickSortByTwoWay(int[] array, int startIndex, int endIndex) {
        /**
         *
         * 功能描述: 基于双向循环的快速排序
         *
         * @param: [array, startIndex, endIndex]
         * @return:
         * @auther: liuyang
         * @date: 2019/11/21 2:27 下午
         */
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = PartitionByTwoWay(array, startIndex, endIndex);
        QuickSortByTwoWay(array, startIndex, pivotIndex - 1);
        QuickSortByTwoWay(array, pivotIndex + 1, endIndex);

    }

    public int PartitionByTwoWay(int[] arr, int startIndex, int endIndex) {
        /**
         *
         * 功能描述: 默认基准点为第一位startIndex,通过前后双向遍历,将数组分类为大于和小于基准点两类,后将基准点放入排序后位置,返回排序后基准点位置
         *
         * @param: [arr, startIndex, endIndex]
         * @return: int
         * @auther: liuyang
         * @date: 2019/11/21 2:54 下午
         */
        int pivot = startIndex;
        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            while (arr[left] > arr[pivot] && left < right) {
                left++;
            }
            while (arr[right] < arr[pivot] && left < right) {
                right--;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[startIndex];
        arr[startIndex] = arr[left];
        arr[left] = temp;

        return left;
    }

}

class QuickSortForOneWay {
    public void QuickSortByOneWay(int[] arr, int startIndex, int endIndex) {
        /**
         *
         * 功能描述: 基于单向排序的快速排序
         *
         * @param: [arr, startIndex, endIndex]
         * @return: int
         * @auther: liuyang
         * @date: 2019/11/21 2:54 下午
         */
        if (startIndex >= endIndex) {
            return;
        }
        int pivot = PartitionByOneWay(arr, startIndex, endIndex);
        QuickSortByOneWay(arr, startIndex, pivot - 1);
        QuickSortByOneWay(arr, pivot + 1, endIndex);

    }

    private int PartitionByOneWay(int[] arr, int startIndex, int endIndex) {

        /**
         *
         * 功能描述: 单边遍历,mark指向小于基准值区的边界,遇到小于基准值的位替换mark位,mark++
         *
         * @param: [arr, startIndex, endIndex]
         * @return: int
         * @auther: liuyang
         * @date: 2019/11/21 3:20 下午
         */

        int mark = startIndex;
        int pivot = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < arr[pivot]) {
                mark++;
                int temp = arr[i];
                arr[i] = arr[mark];
                arr[mark] = temp;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[mark];
        arr[mark] = temp;
        return mark;
    }
}
