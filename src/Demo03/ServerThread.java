package Demo03;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThread extends Thread{

        Socket socket ;
        public ServerThread(Socket socket){
            this.socket = socket;
        }
    @Override
    public void run() {
        InputStream  in =null;
        ObjectInputStream ois = null;
        OutputStream out =null;
        //接收客户端数据
        try {
              in = socket.getInputStream();
            //装饰模式
             ois = new ObjectInputStream(in);
            Object  student = (Student)ois.readObject();
            System.out.println(student);
            socket.shutdownInput();

            //返回文字
             out = socket.getOutputStream();
            out.write("已经收到".getBytes());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                ois.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

