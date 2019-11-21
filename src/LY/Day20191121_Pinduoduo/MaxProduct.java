package LY.Day20191121_Pinduoduo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/11/20 20:17
 * @Description:
 *      problem : 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 *      input description : 输入共2行，第一行包括一个整数n，表示数组长度,第二行为n个以空格隔开的整数，分别为A1,A2, … ,An
 *      input example :
 *      4
 *      3 4 1 2
 *      output :
 *      24
 */
public class MaxProduct {

    public static void main(String[] args) {
        /**
         *
         * 功能描述: 插入排序想法,筛选正数最大三位和负数最小两位,结果比较
         * 注: 无正数情况
         *
         * @param: [args]
         * @return: void
         * @auther: liuyang
         * @date: 2019/11/20 8:22 下午
         */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int index;
        int max1 = 0, max2 = 0, max3 = 0, low1 = 0, low2 = 0;
        Boolean maxFull = false, lowFull = false, has0 = false;
        //输入时判断
        for (int i = 0; i < num; i++) {
            index = scanner.nextInt();
            if (index > 0) {
                //判断三个max是否满，按max1>max2>max3排序
                if (maxFull) {
                    //大->小 插入排序
                    if (index > max1 || index == max1) {
                        max3 = max2;
                        max2 = max1;
                        max1 = index;
                    } else if (index > max2 || index == max2) {
                        max3 = max2;
                        max2 = index;
                    } else if (index > max3) {
                        max3 = index;
                    }

                } else {
                    if (max1 == 0) {
                        max1 = index;
                    } else if (max2 == 0) {
                        if (index > max1) {
                            max2 = max1;
                            max1 = index;
                        } else {
                            max2 = index;
                        }
                    } else {
                        if (index > max1 || index == max1) {
                            max3 = max2;
                            max2 = max1;
                            max1 = index;

                        } else if (index > max2 || index == max2) {
                            max3 = max2;
                            max2 = index;
                        } else {
                            max3 = index;
                        }
                        maxFull = true;
                    }

                }
            }
            else if (index < 0) {
                //判断两个low是否满，按low1<low2排序
                if (lowFull) {
                    if (index < low1 || index == low1) {
                        low2 = low1;
                        low1 = index;
                    } else if (index < low2 || index == max2) {
                        low2 = index;
                    }
                } else {
                    if (low1 == 0) {
                        low1 = index;
                    } else if (low2 == 0) {
                        if (index < low1) {
                            low2 = low1;
                            low1 = index;
                        } else {
                            low2 = index;
                        }
                        lowFull = true;
                    }
                }
            } else has0 = true;
        }
        //特殊值 无正数
        if(!maxFull){
            if (max1 ==0&&has0) System.out.println(0);
        }
        BigDecimal bigDecimal1 = new BigDecimal(max1);
        BigDecimal bigDecimal2 = new BigDecimal(max2);
        BigDecimal bigDecimal3 = new BigDecimal(max3);
        BigDecimal bigDecimal4 = new BigDecimal(low1);
        BigDecimal bigDecimal5 = new BigDecimal(low2);
        BigDecimal result1 = bigDecimal1.multiply(bigDecimal2).multiply(bigDecimal3);
        BigDecimal result2 = bigDecimal1.multiply(bigDecimal4).multiply(bigDecimal5);
        if(result1.compareTo(result2) == -1){
            System.out.println(result2.longValue());
        }
        else {
            System.out.println(result1.longValue());
        }

    }
}
