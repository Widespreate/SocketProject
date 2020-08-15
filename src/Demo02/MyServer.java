package Demo02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        ObjectInputStream ois = null;
        try {
            serverSocket = new ServerSocket(8888);
            socket = serverSocket.accept();

            //收客户端发来的对象
            in = socket.getInputStream();
            //包装
            ois = new ObjectInputStream(in);
            try {
                Student student = (Student) ois.readObject();
                System.out.println(student);
                socket.shutdownInput();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) ois.close();
                if (in != null) in.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
