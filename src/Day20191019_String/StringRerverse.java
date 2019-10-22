package Day20191019_String;

/*
* 字符串逆序输出 2019.10.19
* */
public class StringRerverse {
    public static void main(String[] args) {
        System.out.println(reverseString("abc def"));
        System.out.println(reverseString2("abc def"));
    }
    private static String reverseString(String initString) {
        String resultString = "";
        for (int i = initString.length() - 1; i>=0 ;i--) {
            char str = initString.charAt(i);
            resultString = resultString + str;
        }
        return resultString;
    }

    private static String reverseString2(String initString) {
        StringBuilder stringBuilder = new StringBuilder(initString);
        return stringBuilder.reverse().toString();
    }
}
