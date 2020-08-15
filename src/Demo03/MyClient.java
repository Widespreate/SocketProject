package Demo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out = null;
        ObjectOutputStream oos = null;

        try {
            socket = new Socket("localhost", 8888);
            Student student = new Student(1001, "zs", 23);
            out = socket.getOutputStream();
            //将输出流编程对象流.装饰模式
            oos = new ObjectOutputStream(out);
            oos.writeObject(student);
            socket.shutdownOutput();

            InputStream in = socket.getInputStream();
            byte[] buf = new byte[100];
            in.read(buf);
            System.out.println("接收到服务端返葵"+new String(buf));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (oos != null) oos.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
