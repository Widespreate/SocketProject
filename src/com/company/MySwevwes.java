package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MySwevwes {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        BufferedReader reader = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务端启动");
            socket = serverSocket.accept();
            System.out.println("服务端检测到客户端链接成功");

            in = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            String info = null;
            if((info=reader.readLine())!= null){
                System.out.println("服务器节后到信息了"+info);
            }
            socket.shutdownInput();


            out = socket.getOutputStream();
            out.write("wlecome client ".getBytes());
            socket.shutdownOutput();

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
               if(reader!=null) reader.close();
                if(out!=null)out.close();
                if(in!=null)in.close();
                if(socket!=null)socket.close();
                if(serverSocket!=null)serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

