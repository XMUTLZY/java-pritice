package LY.Day20191121_Pinduoduo;

import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/11/21 10:31
 * @Description:有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型。
 */
public class MultiplicationOfLargeNumbers {

        public void reverseString(char[] s) {
            /**
             *
             * 功能描述: 字符数组反转
             *
             * @param: [s]
             * @return: void
             * @auther: liuyang
             * @date: 2019/11/21 10:33 上午
             */
            for (int i = 0; i < s.length / 2; i++) {
                char temp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = temp;
            }
        }
        public void add(String num1,String num2){
            /**
             *
             * 功能描述: 大数乘法主要函数
             *          字符串数组实现小学乘法,进位则调用进位函数(递归)
             *
             * @param: [num1, num2]
             * @return: void
             * @auther: liuyang
             * @date: 2019/11/21 10:33 上午
             */
            int temp;
            char str1[] = num1.toCharArray();
            char str2[] = num2.toCharArray();
            reverseString(str1);
            reverseString(str2);
//        System.out.println(String.valueOf(str1)+":"+String.valueOf(str2));
            char result[] = new char[str1.length+str2.length];
            for(int i=0;i<str1.length+str2.length;i++){
                result[i]='0';
            }
            for(int i=0;i<str1.length;i++){
                for(int j=0;j<str2.length;j++){
                    temp = (str1[i]-'0')*(str2[j]-'0');
                    jinwei(result,i+j,temp);
                }
//            System.out.println(String.valueOf(result));
            }

            reverseString(result);
            delete0(result);

        }
        public void jinwei(char[] str,int index,int addNum){
            /**
             *
             * 功能描述: 进位函数
             *          str:被进位字符数组
             *          index:进位位置
             *          addnum:进位数字
             *
             * @param: [str, index, addNum]
             * @return: void
             * @auther: liuyang
             * @date: 2019/11/21 10:35 上午
             */
            if((str[index]-'0')+addNum>=10){
                jinwei(str, index+1, ((str[index]-'0')+addNum)/10);
                str[index] = (char)(((str[index]-'0')+addNum)%10+'0');

            }
            else str[index] = (char)(((str[index]-'0')+addNum)+'0');
        }

        public void delete0(char[] str){
            /**
             *
             * 功能描述: 输出时删除数组前的0
             *
             * @param: [str]
             * @return: void
             * @auther: liuyang
             * @date: 2019/11/21 10:36 上午
             */
            int length = str.length;
            for(int i=0;i<length;i++){
                if(str[i]!='0'){
                    String s = String.valueOf(str);

                    System.out.println(s.substring(i,length));
                    break;
                }
            }
        }

        public static void main(String[] args) {
            /**
             *
             * 功能描述: 输入参数
             *
             * @param: [args]
             * @return: void
             * @auther: liuyang
             * @date: 2019/11/21 10:37 上午
             */
            Scanner scanner = new Scanner(System.in);
            String num1 = scanner.next();
            String num2 = scanner.next();
            MultiplicationOfLargeNumbers main = new MultiplicationOfLargeNumbers();

            main.add(num1,num2);

        }

}
