package LY.Day20191201_IO.ObjectOperation;

import java.io.*;

/**
 * @Auther: liuyang
 * @Date: 2019/12/1 22:15
 * @Description: 序列化操作
 */
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        A a1 = new A(123, "abc");
        String objectFile = "/Users/ly/IdeaProjects/a.txt";

        a1.setElementData("as");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
        /**
         * public FileOutputStream(String name)
         *                  throws FileNotFoundException
         * 创建文件输出流以指定的名称写入文件。 创建一个新的FileDescriptor对象来表示此文件连接。
         * 首先，如果有一个安全管理器，它的checkWrite方法name作为参数来调用。
         *
         * 如果文件存在但是是一个目录而不是常规文件，不存在但不能创建，或者由于任何其他原因无法打开，那么抛出一个FileNotFoundException 。
         */
        objectOutputStream.writeObject(a1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
        A a2 = (A) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(a2);
    }

    private static class A implements Serializable {



        /**
         * transient 关键字可以使一些属性不会被序列化
         */
        private transient String elementData;
        private int x;
        private String y;

        public void setElementData(String elementData) {
            this.elementData = elementData;
        }

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + "  " + "y = " + y;
        }
    }
}
