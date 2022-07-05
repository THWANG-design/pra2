package Dough.Chapter4;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WebServer {

    public void start(){
        try {
            ServerSocket server = new ServerSocket(9000);
            ExecutorService pool = Executors.newCachedThreadPool();
            System.out.println("Web服务器启动，端口号为9000");

            while(!pool.isShutdown()){
                final Socket socket = server.accept();
                pool.execute(handleRequest(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Runnable handleRequest(Socket socket){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                    byte[] buffer = new byte[1024];
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    int len = 0;

                    while((len = dis.read(buffer)) != -1){
                        bos.write(buffer,0, len);
                    }
                    String resMsg = new String(bos.toByteArray(),"iso-8859-1");
                    System.out.println(Thread.currentThread().getId() + "收到" + resMsg);
                    bos.close();
                    dis.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        return runnable;
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                new WebServer().start();
            }
        }).start();
    }
}
