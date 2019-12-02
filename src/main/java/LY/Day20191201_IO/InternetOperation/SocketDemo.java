package LY.Day20191201_IO.InternetOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: liuyang
 * @Date: 2019/12/2 08:35
 * @Description:
 */
public class SocketDemo {
    /**
     * 1.创建一个Socket实例
     * 　　2.利用I/O流与服务器进行通信
     * 　　3.关闭socket
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) {
        while (true) {
            Socket socket = null;
            try {
                socket = new Socket("localhost", 8080);
                /**
                 * 读取服务器端数据
                 */
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                /**
                 * 向服务器端发送数据
                 */
                PrintStream out = new PrintStream(socket.getOutputStream());
                System.out.print("请输入: \t");
                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.println(str);

                String ret = input.readLine();
                System.out.println("服务器端返回过来的是: " + ret);
                // 如接收到 "OK" 则断开连接
                if ("OK".equals(ret)) {
                    System.out.println("客户端将关闭连接");
                    Thread.sleep(500);
                    break;
                }
                input.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        socket = null;
                        System.out.println("客户端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }

    }
}
