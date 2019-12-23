package com.goisan;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketDemo {
    //客户端
    public static void main(String[] args) throws IOException {
        while(true){
        Socket socket = new Socket("localhost",8080);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要发送的消息");
        String nextText = scanner.next();
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(nextText.getBytes());
        outputStream.flush();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println("服务端给您回复了消息:"+new String(bytes));
        }
    }
}
