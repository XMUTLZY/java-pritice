package LZY.Day20200116_Algorithm.Test1;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 * 思路:从左下或者右上进行查找，如：从右上开始查找，当目标数比当前值大时，当前值向下移动一位；当目标数比当前值
 * 小时，当前值向左移动一位。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int array[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
        System.out.println(solution.Find(11, array));
    }

    public boolean Find(int target, int [][] array) {
        int line = array.length; //行数
        int column = array[0].length; //列数
        for (int i = 0; i<line; i++) {
            for (int j = column-1; j>=0; j--) {
                if (array[i][j] == target) {
                    return true;
                }
                if (array[i][j] < target) {//目标数更大 则向下移动
                    break;
                }
            }
        }
        return false;
    }
}
