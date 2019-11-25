package LY.Day20191121_Algorithm.Day20191122_DynamicProgramming;

import java.util.Arrays;

/**
 * @Auther: liuyang
 * @Date: 2019/11/22 17:56
 * @Description: 动态规划 最长滑雪路径
 */
public class LongWayWithArray {
    public static void main(String[] args) {
        int a[][] = new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
                {90, 92, 91, 94, 93}
        };
        int record[][] = new int[a.length][a[0].length];
        int min = Integer.MAX_VALUE;
        int max = 0;
        int max_x = 0;
        int max_y = 0;
        for (int i = 0; i < a.length; i++) { //初始化数组
            for (int j = 0; j < a[0].length; j++) {
                record[i][j] = -1;
                if (a[i][j] < min) {
                    min = a[i][j];
                } else if (a[i][j] > max) {
                    max = a[i][j];
                    max_x = i;
                    max_y = j;
                }
            }

        }
        for (int i = 0; i < a.length; i++) { //设置边界
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] == min) {
                    record[i][j] = 1;
                }
        }
        System.out.println(new LongWayWithArray().dp(a, max_x, max_y, record));

    }

    private int dp(int[][] arr, int x, int y, int[][] record) {
        /**
         *
         * 功能描述: 当前位置{x,y}路径最大值为f(x,y) = Max{f(x-1,y)+1,f(x,y+1)+1,f(x+1,y)+1,f(x,y-1)+1}
         *
         *
         * @param: [arr, x, y, record]
         * @return: int
         * @auther: liuyang
         * @date: 2019/11/22 6:03 下午
         */
        int ans = 0; //当前点的最长路径

        if (x - 1 >= 0 && record[x - 1][y] != -1) { // &&前防止数组溢出
            ans = Math.max(ans, record[x - 1][y] + 1);
        } else if (x - 1 >= 0 && arr[x - 1][y] < arr[x][y]) {
            record[x - 1][y] = dp(arr, x - 1, y, record);
            ans = Math.max(ans, record[x - 1][y] + 1);
        }
        if (x + 1 < arr.length && record[x + 1][y] != -1) {
            ans = Math.max(ans, record[x + 1][y] + 1);
        } else if (x + 1 < arr.length && arr[x + 1][y] < arr[x][y]) {
            record[x + 1][y] = dp(arr, x + 1, y, record);
            ans = Math.max(ans, record[x + 1][y] + 1);
        }
        if (y - 1 >= 0 && record[x][y - 1] != -1) {
            ans = Math.max(ans, record[x][y - 1] + 1);
        } else if (y - 1 >= 0 && arr[x][y - 1] < arr[x][y]) {
            record[x][y - 1] = dp(arr, x, y - 1, record);
            ans = Math.max(ans, record[x][y - 1] + 1);
        }
        if (y + 1 < arr[0].length && record[x][y + 1] != -1) {
            ans = Math.max(ans, record[x][y + 1] + 1);
        } else if (y + 1 < arr[0].length && arr[x][y + 1] < arr[x][y]) {
            record[x][y + 1] = dp(arr, x, y + 1, record);
            ans = Math.max(ans, record[x][y + 1] + 1);
        }
        return ans;
    }
}


