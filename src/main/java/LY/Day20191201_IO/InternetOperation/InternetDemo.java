package LY.Day20191201_IO.InternetOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Auther: liuyang
 * @Date: 2019/12/1 22:26
 * @Description:
 */
public class InternetDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");

        /* 字节流 */
        /**
         * URL.openStream()   打开与此URL ，并返回一个InputStream用于从该连接读取。
         */
        InputStream is = url.openStream();

        /* 字符流 */
        InputStreamReader isr = new InputStreamReader(is, "utf-8");

        /**
         * JDK1.8: 为了最大的效率，请考虑在BufferedReader中包装一个InputStreamReader。 例如：
         *          BufferedReader in
         *              = new BufferedReader(new InputStreamReader(System.in));
         */
        /* 提供缓存功能 */
        BufferedReader br = new BufferedReader(isr);

        String line;
        /**
         * BufferedReader.readLine()
         *             读一行文字。 一行被视为由换行符（'\ n'），回车符（'\ r'）中的任何一个或随后的换行符终止。
         */
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
