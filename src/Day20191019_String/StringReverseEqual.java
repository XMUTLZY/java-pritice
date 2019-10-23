package Day20191019_String;

/**
 * 翻转子串  2019.10.23
 */
public class StringReverseEqual {
    public static void main(String[] args) {
        System.out.println(reverseEqual("cba", "cba"));
        System.out.println(reverseEqual("abc ", "cba"));
    }

    private static Boolean reverseEqual(String s1, String s2) {
        StringBuilder stringBuilder1 = new StringBuilder(s1);
        StringBuilder stringBuilder2 = new StringBuilder(s2);
        for (int i = 0; i<stringBuilder1.length()-1; i++) {
            for (int j = i+1; j<stringBuilder1.length(); j++) {
                if (stringBuilder1.charAt(i) > stringBuilder1.charAt(j)) {
                    char temp = stringBuilder1.charAt(i);
                    stringBuilder1.replace(i, i+1, stringBuilder1.charAt(j) + "");
                    stringBuilder1.replace(j, j+1, temp + "");
                }
            }
        }
        for (int i = 0; i<stringBuilder2.length()-1; i++) {
            for (int j = i+1; j<stringBuilder2.length(); j++) {
                if (stringBuilder2.charAt(i) > stringBuilder2.charAt(j)) {
                    char temp = stringBuilder2.charAt(i);
                    stringBuilder2.replace(i, i+1, stringBuilder2.charAt(j) + "");
                    stringBuilder2.replace(j, j+1, temp + "");
                }
            }
        }
        return stringBuilder1.toString().equals(stringBuilder2.toString());
    }

    private static Boolean reverseEqual2(String s1, String s2) {
        String temp = s1 + s2;
        return temp.contains(s2);
    }
}
