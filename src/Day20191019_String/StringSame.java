package Day20191019_String;

/*
* 确定两个字符串乱序同构
* */
public class StringSame {
    public static void main(String[] args) {
        System.out.println(same("abcde", "edcba"));
        System.out.println(same("abc cba", "abc Cba"));
    }
    private static Boolean same(String string1, String string2) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        if (string1.length() != string2.length()) {
            return false;
        }
        for (int i = 0; i<string1.length(); i++) {
            arr1[string1.charAt(i)]++;
        }
        for (int j = 0; j<string2.length(); j++) {
            arr2[string2.charAt(j)]++;
        }
        for (int k = 0; k<256; k++) {
            if (arr1[k] != arr2[k])
                return false;
        }
        return true;
    }
}
