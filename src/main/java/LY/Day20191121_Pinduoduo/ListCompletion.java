package LY.Day20191121_Pinduoduo;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/11/24 09:22
 * @Description: 在商城的某个位置有一个商品列表，该列表是由L1、L2两个子列表拼接而成。当用户浏览并翻页时，需要从列表L1、L2中获取商品进行展示。展示规则如下：
 * <p>
 * 1. 用户可以进行多次翻页，用offset表示用户在之前页面已经浏览的商品数量，比如offset为4，表示用户已经看了4个商品
 * <p>
 * 2. n表示当前页面需要展示的商品数量
 * <p>
 * 3. 展示商品时首先使用列表L1，如果列表L1长度不够，再从列表L2中选取商品
 * <p>
 * 4. 从列表L2中补全商品时，也可能存在数量不足的情况
 * <p>
 * 请根据上述规则，计算列表L1和L2中哪些商品在当前页面被展示了
 * <p>
 * 输入描述:
 * 每个测试输入包含1个测试用例，包含四个整数，分别表示偏移量offset、元素数量n，列表L1的长度l1，列表L2的长度l2。
 * <p>
 * 输出描述:
 * 在一行内输出四个整数分别表示L1和L2的区间start1，end1，start2，end2，每个数字之间有一个空格。
 * 注意，区间段使用半开半闭区间表示，即包含起点，不包含终点。如果某个列表的区间为空，使用[0, 0)表示，如果某个列表被跳过，使用[len, len)表示，len表示列表的长度。
 * <p>
 * 输入例子1:
 * 2 4 4 4
 * 1 2 4 4
 * 4 1 3 3
 * <p>
 * 输出例子1:
 * 2 4 0 2
 * 1 3 0 0
 * 3 3 1 2
 */
public class ListCompletion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {    //类似于C scanf(...)!=EOF

            int offset = scanner.nextInt();
            int n = scanner.nextInt();
            int l1 = scanner.nextInt();
            int l2 = scanner.nextInt();

            System.out.println(Math.min(offset,l1)+" "+Math.min(offset+n,l1)+" "+Math.min(Math.max(offset-l1,0),l2)+" "+Math.min(Math.max(offset+n-l1,0),l2));

        }
    }
}
