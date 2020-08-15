package com.company;

import java.io.*;
import java.net.Socket;


public class MyClient {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream out =null;
        InputStream in = null;
                BufferedReader reader =null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接成功");

             out = socket.getOutputStream();
             out.write("hello server".getBytes());
             socket.shutdownOutput();


             //接收服务端的反馈
             in = socket.getInputStream();
             reader = new BufferedReader(new InputStreamReader(in));
            String info = null;
            while((info=reader.readLine())!=null){
                System.out.println("I am client,接收到服务端的消息"+info);
            }
            socket.shutdownInput();


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
               if(out!=null) out.close();
                if(in!=null)  in.close();
                if(socket!=null)socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
