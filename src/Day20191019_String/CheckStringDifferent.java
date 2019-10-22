package Day20191019_String;

/*
* 字符串异同比较 2019.10.19
* */
public class CheckStringDifferent {
    public static void main(String[] args) {
        System.out.println(checkDifferent("abcc"));
        System.out.println(checkDifferent("abc"));
        System.out.println(checkDifferent2("abcc"));
        System.out.println(checkDifferent2("abc"));
        System.out.println(checkDifferent3("abcc"));
        System.out.println(checkDifferent3("abc"));
    }
    private static boolean checkDifferent(String initString) {
        for (int i = 0; i<initString.length()-1; i++) {
            for (int j = i+1; j<initString.length(); j++) {
                if (initString.charAt(i) == initString.charAt(j))
                    return false;
            }
        }
        return true;
    }

    private static boolean checkDifferent2(String initString) {
        //ASCLL编码 0~255  如果字符串长度大于256 则肯定有重复字符
        int length = initString.length();
        if (length > 256)
            return false;
        int[] arr = new int[256];
        for (int i = 0; i<initString.length(); i++) {
            int index = initString.toCharArray()[i];
            arr[index]++;
            if (arr[index] > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkDifferent3(String initString) {
        return !initString.matches(".*(.)(.*\\1).*");
    }
}
