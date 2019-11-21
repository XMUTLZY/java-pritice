package LY.Day20191121_Algorithm.Day20191121_BubbleSort;

import java.util.Arrays;

/**
 * @Auther: liuyang
 * @Date: 2019/11/21 12:34
 * @Description: 冒泡排序及优化
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int array[] = new int[]{9, 5, 1, 2, 5, 11, 52, 42, 12, 8};
        new BubbleSort().sort(array);
        int array1[] = new int[]{9, 5, 1, 2, 5, 11, 52, 42, 12, 8};
        new BubbleSortUpdate().sort(array1);
        int array2[] = new int[]{9, 5, 1, 2, 5, 11, 52, 42, 12, 8};
        new CocktailSort().sort(array2);
        int array3[] = new int[]{2,3,4,5,6,7,1,8};
        new BubbleSortUpdate().sort(array3);
    }
}

class BubbleSort {
    public void sort(int array[]) {
        /**
         *
         * 功能描述: 标准冒泡排序
         *
         * @param: [array]
         * @return: void
         * @auther: liuyang
         * @date: 2019/11/21 12:59 下午
         */
        int count = 0;//排序次数
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                count++;
            }
        }

        System.out.print(Arrays.toString(array));
        System.out.println("排序次数:" + count);
    }
}

class BubbleSortUpdate {
    public void sort(int array[]) {
        /**
         *
         * 功能描述: 冒泡排序升级版
         *          每次遍历对数组检查 是否排序
         *
         * @param: [array]
         * @return: void
         * @auther: liuyang
         * @date: 2019/11/21 12:58 下午
         */
        boolean isSorted = true;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            count++;
            if (isSorted) {
                break;
            }
        }

        System.out.print(Arrays.toString(array));
        System.out.println("排序次数:" + count);
    }
}

class CocktailSort {
    public void sort(int array[]) {
        /**
         *
         * 功能描述: 鸡尾酒排序(冒泡排序升级版)
         *          第一轮从左至右、第二轮从右至左、以此类推
         *
         * @param: [array]
         * @return: void
         * @auther: liuyang
         * @date: 2019/11/21 12:57 下午
         */
        boolean isSorted = true;
        int count = 0;
        int j = 0;
        int temp = 0;
        for (int i = 0; i < array.length / 2; i++) {
            isSorted = true;
            for (j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = array[j + 1];
                    isSorted = false;
                }
                count++;
            }
            if (isSorted)
                break;
            isSorted = true;
            for (j = array.length - i - 1; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = array[j - 1];
                    isSorted = false;
                }
                count++;
            }
            if (isSorted)
                break;
        }
        System.out.print(Arrays.toString(array));
        System.out.println("排序次数:" + count);
    }
}
