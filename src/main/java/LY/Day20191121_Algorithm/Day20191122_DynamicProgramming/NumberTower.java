package LY.Day20191121_Algorithm.Day20191122_DynamicProgramming;

import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/11/22 22:27
 * @Description: url: http://acm.hdu.edu.cn/showproblem.php?pid=2084
 */
public class NumberTower {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int c = scan.nextInt();
        while (c > 0) {

            int n = scan.nextInt();
            int array[][] = new int[n][n];
            int record[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    array[i][j] = scan.nextInt();
                    if (i == n-1) record[i][j] = array[i][j];
                    else record[i][j] = -1;
                }
            }
            new NumberTower().dp(array,0,0,record);
            System.out.println(record[0][0]);
            c--;
        }

    }
    public int dp(int[][] array,int x,int y,int[][] record){
        /**
         * 状态转移方程 f(x,y) = max(f(x+1,y),f(x+1,y+1))
         */
        if(record[x][y]!=-1)
            return record[x][y];

        record[x][y] = Math.max(dp(array,x+1,y,record)+array[x][y],dp(array, x+1, y+1, record)+array[x][y]);
        return record[x][y];
    }
}
