package LZY.Day20191019_String;

/*
* 字符串空格替换 2019.10.19
* */
public class StringReplaceSpace {
    public static void main(String[] args) {
        System.out.println(replaceSpace("hello  world", 12));
        System.out.println(replaceSpace2("hello  world", 12));
    }
    private static String replaceSpace(String string, int length) {
        String resultStr = "";
        for (int i = 0; i<length; i++) {
            if (string.charAt(i) == ' ') {
                resultStr = resultStr + "%20";
            } else
                resultStr = resultStr + string.charAt(i);
        }
        return resultStr;
    }

    private static String replaceSpace2(String string, int length) {
        return string.replaceAll(" ", "%20");
    }
}
