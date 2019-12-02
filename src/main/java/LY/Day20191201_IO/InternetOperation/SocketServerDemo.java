package LY.Day20191201_IO.InternetOperation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Auther: liuyang
 * @Date: 2019/12/2 08:35
 * @Description:
 */
public class SocketServerDemo {
    /**
     * 服务器接收客户端请求步骤：
     * 　　１.创建一个ServerSocket实例，监听客户端发来的请求。
     * 　　2.与客户端获取连接后，创建一个Socket实例，利用I/O流与客户端进行通信，完毕后关闭Socket。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        SocketServerDemo socketServerDemo = new SocketServerDemo();
        socketServerDemo.init();
    }

    public void init() {
        try {
            /**
             * 连接请求队列长度为3
             */
            ServerSocket serverSocket = new ServerSocket(8080, 3);
            while (true){
                Socket socket = serverSocket.accept();
                new HandlerSocket(socket);
            }
            //从请求队列取一个


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class HandlerSocket implements Runnable {
        Socket socket = null;

        public HandlerSocket(Socket socket) {
            this.socket = socket;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inputStr = input.readLine();

                PrintStream out = new PrintStream(socket.getOutputStream());
                System.out.print("请输入:\t");

                String s = new Scanner(System.in).next();
                /**
                 * println()方法就是write()+另起一行
                 *
                 * JDK将 out.write(String str)设置为private 封装给print(String str)用
                 */
                out.println(s);
                /**
                 * println(String str){
                 *      print(str);
                 *      newLine();
                 * }
                 */

//        等价:  out.print(s);
//              out.println();


                out.close();
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }
}
