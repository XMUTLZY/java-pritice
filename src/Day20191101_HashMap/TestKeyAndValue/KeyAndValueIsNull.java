package Day20191101_HashMap.TestKeyAndValue;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试key和value为null的情况
 */
public class KeyAndValueIsNull {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put(null, null);//当key和value都为null时
        System.out.println(map1.get(null));
        map1.put(null, "test");//当key为null，value不为null时
        System.out.println(map1.get(null));
    }
}
