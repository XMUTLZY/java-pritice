package LY.Day20191121_Algorithm.Day20191122_DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/11/23 08:38
 * @Description: url:http://acm.hdu.edu.cn/showproblem.php?pid=2018
 */
public class RowChilds {
    public static void main(String[] args) {
        int n = 0;
        int record[] = new int[55];//共55年
        record[0] = 1;
        record[1] = 2;
        record[2] = 3;
        record[3] = 4;
        record[4] = 6;
        Scanner scanner = new Scanner(System.in);
        new RowChilds().digui(record, 55);
        while ((n = scanner.nextInt()) != 0) {
            if (record[n - 1] != 0) {
                System.out.println(record[n - 1]);
            }
        }
    }

    int digui(int[] record, int year) {
        /**
         *
         * 功能描述: 递推方程 f(n) = f(n-1) +f(n-3)
         *          使用record记录
         *
         * @param: [record, year]
         * @return: int
         * @auther: liuyang
         * @date: 2019/11/23 9:10 上午
         */
        if (record[year - 1] != 0)
            return record[year - 1];
        record[year - 1] = digui(record, year - 3) + digui(record, year - 1);
        return record[year - 1];
    }

}
