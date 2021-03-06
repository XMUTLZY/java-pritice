package LY.Day20191201_IO.DiskOperation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Auther: liuyang
 * @Date: 2019/12/1 21:56
 * @Description: FileInputStream、FileOutputStream
 *
 * 注: Java I/O 使用了装饰者模式来实现。以 InputStream 为例，
 *      InputStream 是抽象组件；
 *      FileInputStream 是 InputStream 的子类，属于具体组件，提供了字节流的输入操作；
 *      FilterInputStream 属于抽象装饰者，装饰者用于装饰组件，为组件提供额外的功能。例如 BufferedInputStream 为 FileInputStream 提供缓存的功能。
 */
public class FileCopy {
    public void copyFile(String src,String dist) throws IOException {

        FileInputStream inputStream = new FileInputStream(src);
        FileOutputStream outputStream = new FileOutputStream(dist);

        byte[] buffer = new byte[20*1024];
        int cnt;
        /**
         * public int read(byte[] b,
         *                 int off,
         *                 int len)
         *          throws IOException
         * 从该输入流读取最多len字节的数据为字节数组。 如果len不为零，该方法将阻塞，直到某些输入可用; 否则，不会读取字节，并返回0 。
         */

        while ((cnt = inputStream.read(buffer, 0, buffer.length)) != -1) {
            outputStream.write(buffer, 0, cnt);
            /**
             * public void write(byte[] b,
             *                   int off,
             *                   int len)
             *            throws IOException
             * 从位于偏移量 off的指定字节数组写入 len字节到该文件输出流。
             */
        }

    }
}
