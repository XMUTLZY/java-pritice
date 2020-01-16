package LZY.Day20200116_Algorithm.Test3;

public class Solution {
    /**
     * 使用递归计算n!
     * 递归思想符合后进先出的原则
     *
     * 5*recursion(4) ↓   5*4*3*2*1  ↑
     * 4*recursion(3) ↓   4*3*2*1    ↑
     * 3*recursion(2) ↓   3*2*1      ↑
     * 2*recursion(1) ↓   2*1        ↑
     * recursion(1)=1  →→→→→→→→↑
     */
    public int recursion1(int n) {
        if (n<2) {
            return 1;
        } else {
            return n*recursion1(n-1);
        }
    }

    /**
     * 利用递归求1+2+3+...+n
     */
    public int recursion2(int n) {
        if (n==1) {
            return 1;
        } else {
            return n+recursion2(n-1);
        }
    }

    /**
     * 利用递归实现回文字符串判断
     */
    public boolean recursion3(String str) {
        if (str.length() == 1 || str.length() == 0) {
            return true;// 只有一个字符或者空字符肯定是回文字符串
        } else {
            if (str.charAt(0) == str.charAt(str.length()-1)){
                return recursion3(str.substring(1, str.length()-1));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.recursion1(5));
        System.out.println(solution.recursion2(5));
        System.out.println(solution.recursion3("aabccbaa"));//去掉头个字符;
    }
}
