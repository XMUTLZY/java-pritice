package LZY.Day20191019_String;

import java.util.Arrays;

/*
 * 像素翻转,顺时针旋转90 2019.10.22
 * */
public class ArrayTrans {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(trans(arr, 3)));
    }

    private static int[][] trans(int[][] arr, int num) {
        for (int i = 0; i < num/2; i++) {
            for (int j = 0; j < num; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[num-1-i][j];
                arr[num-1-i][j] = temp;
            }
        }
        for (int i = 0; i < num; i++) {
            for (int j = i+1; j > i && j < num; j++) {
                int temp2 = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp2;
            }
        }
        return arr;
    }
}
