package LY.Day20191121_Pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/11/21 10:43
 * @Description:
 *              url:https://www.nowcoder.com/test/6161937/summary
 *
 *              六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i]
 *              (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。
 *              可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 *              input description:
 *                                第一行：n，表示h数组元素个数
 *                                第二行：n个h数组元素
 *                                第三行：m，表示w数组元素个数
 *                                第四行：m个w数组元素
 *               output description:
 *                                上台表演学生人数
 */
public class BestDistribution {


        public static void main(String[] args) {
            /**
             *
             * 功能描述: 将奖品与学生需求排序,从大至小分配
             *
             * @param: [args]
             * @return: void
             * @auther: liuyang
             * @date: 2019/11/21 10:46 上午
             */
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] h = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                h[i] = scanner.nextInt();
            }

            int m = scanner.nextInt();
            int[] w = new int[m];
            for (int i = 0; i < m; i++) {
                w[i] = scanner.nextInt();
            }

            Arrays.sort(h);
            Arrays.sort(w);
            for (int hi = 0; hi < n; hi++) {
                for (int wi = 0; wi < m; wi++) {
                    if(w[wi]>=h[hi]){
                        w[wi] = -1;
                        h[hi] = 65535;
                        sum++;
                    }
                }
            }
            System.out.println(sum);

        }
    }

