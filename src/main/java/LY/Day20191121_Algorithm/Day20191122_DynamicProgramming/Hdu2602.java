package LY.Day20191121_Algorithm.Day20191122_DynamicProgramming;

import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/11/23 09:28
 * @Description: url: http://acm.hdu.edu.cn/showproblem.php?pid=2602
 */
public class Hdu2602 {
    public static void main(String[] args) {
        /**
         *
         * 功能描述: 测试数据
         * 1
         * 5 0
         * 2 4 1 5 1
         * 0 0 1 0 0
         *
         * @param: [args]
         * @return: void
         * @auther: liuyang
         * @date: 2019/11/23 10:24 上午
         */
        int t = 0, n = 0, v = 0;
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt(); //一共几根骨头
            v = scanner.nextInt(); //背包体积
            int value[] = new int[n + 1];   //骨头的价值
            int volume[] = new int[n + 1];  //骨头的体积
            int record[][] = new int[n + 1][v + 1]; //记录表
            for (int i = 1; i < n + 1; i++) {
                value[i] = scanner.nextInt();
            }
            for (int i = 1; i < n + 1; i++) {
                volume[i] = scanner.nextInt();
            }

            for (int i = 1; i <= n; i++)  //前i根骨头的最优情况
                for (int j = 0; j <= v; j++) { //背包体积 考虑背包体积为0情况
                    if ( j < volume[i]){
                        record[i][j] = record[i-1][j];
                    }
                    else {
                        /**
                         * 状态转移方程: 当前背包体积j下,前i根骨头的最大价值 = max( 这根骨头不放的价值, 放这根骨头的价值)
                         * 放骨头的情况: 价值为 (前i-1根骨头情况下,空余出第i根骨头的最大价值) + 第i根骨头的价值
                         */
                        record[i][j] = Math.max(record[i-1][j],record[i-1][j-volume[i]]+value[i]);
                    }
                }

            System.out.println( record[n][v]);
        }

    }
}
