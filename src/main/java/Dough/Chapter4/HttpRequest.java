package Dough.Chapter4;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpRequest {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 50; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        final Socket socket = new Socket("localhost", 9000);
                        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                        String msg = Thread.currentThread().getId() + "hello";
                        dos.write(msg.getBytes("iso-8859-1"));
                        System.out.println("发送" + msg);
                        dos.flush();
                        socket.shutdownOutput();
                        dos.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
