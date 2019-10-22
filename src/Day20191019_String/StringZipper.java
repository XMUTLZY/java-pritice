package Day20191019_String;

/*
* 字符串压缩  2019.10.21
* */
public class StringZipper {
    public static void main(String[] args) {
        System.out.println(zipper("jjjjjjxxxxxxxooZLLLLLLLLQQQQQQQQQLLLLLLLLECXXXXXXXIIIIIIIIIhjjyyySSooooooooommmuuEEEEEEEEEnnnnnnnffffffAAAAAllllllllbbbbkkkkkkkkkkkkKKKKKKhhhhhhhhhooooooooooYCCCCCCOOOOOOOOOMMMMMMMMMMiiiiiivvvvvvvWWWWkkkkkkwwwwwwwMmmmmmmmmLLLwwwwwwwkkkjjjjjjttttQQQQQQQQQaaaaaaaFFFFFFFlllllllllggggggggggPPPPPPuuuuuuuuaYYYYYYwQQQFFFFFFFFFFaaaaapXXXXXXXxxxxxxQQQQQQQQQsssssGGGGfffffffddddddpppQQQQQQHHHTTTaaaaaaGGGGGGddyyyyyMhhllllllllllNNNNNNNNUUUWWWWWWLLLLLLLLLYYYYYYYYYYTTKKKKKKKKiiiiiiitttttttXXXXXXXXXLLLHZZZZZZZssssjjJJJEEEEEOOOOOttttttttttBBttttttTTTTTTTTTTrrrrttttRRRRRyyooooooaaaaaaaaarrrrrrrPPPPPPPjjPPPPddddddddddHHHHnnnnnnnnnnSSSSSSSSSSzzHHHHHHHHHddddddDDDzzzhhhhhfffffffffftttttteeeeeeeeEEEEEEEEEaaaaaaccccccccccFFFFFFFF"));
    }

    private static String zipper(String iniString) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char first = iniString.charAt(0);
        for(int i = 1; i<iniString.length(); i++) {
            if (first == iniString.charAt(i))
                count++;
            else {
                stringBuilder.append(first + "" + count);
                first = iniString.charAt(i);
                count = 1;
            }
        }
        stringBuilder.append(first + "" + count);
        return stringBuilder.toString().length() > iniString.length() ? iniString:stringBuilder.toString();
    }
}
