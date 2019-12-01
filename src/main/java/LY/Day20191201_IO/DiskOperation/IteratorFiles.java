package LY.Day20191201_IO.DiskOperation;

import LY.Day20191121_Pinduoduo.MaxProduct;

import java.io.File;
import java.nio.file.Files;

/**
 * @Auther: liuyang
 * @Date: 2019/12/1 20:29
 * @Description: 磁盘遍历文件
 */
public class IteratorFiles {

    public static void main(String[] args) {
        /**
         * 相对路径  ./默认项目根目录
         */
        File file = new File("./target/classes/LY/Day20191121_Pinduoduo");
        new IteratorFiles().listAllFiles(file);
    }
    public  void listAllFiles(File dir) {
        /**
         *
         * 功能描述:
         *           isFile()：判断是否是文件，也可能是文件或者目录
         *           exists()：判断该文件是否存在
         *
         * @param: [dir]
         * @return: void
         * @auther: liuyang
         * @date: 2019/12/1 9:06 下午
         */
        if (dir == null || !dir.exists()) {
            return;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }
}
