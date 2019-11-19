package Day20191119_PinDuoDuo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 输入共2行，第一行包括一个整数n，表示数组长度
 * 第二行为n个以空格隔开的整数，分别为A1,A2, … ,An
 */
public class MaxProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i<arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        BigDecimal bigDecimal1 = new BigDecimal(arr[n-1]);
        BigDecimal bigDecimal2 = new BigDecimal(arr[n-2]);
        BigDecimal bigDecimal3 = new BigDecimal(arr[n-3]);
        BigDecimal bigDecimal4 = new BigDecimal(arr[0]);
        BigDecimal bigDecimal5 = new BigDecimal(arr[1]);
        BigDecimal result1 = bigDecimal1.multiply(bigDecimal2).multiply(bigDecimal3);
        BigDecimal result2 = bigDecimal4.multiply(bigDecimal5).multiply(bigDecimal1);
        if (result1.compareTo(result2) == -1) {
            System.out.println(result2.longValue());
        } else {
            System.out.println(result1.longValue());
        }
    }
}
