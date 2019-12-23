package com.goisan;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;
import java.util.Scanner;

public class ServerSocketDemo {
    //服务端
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println("客户端给您发送了消息:" + new String(bytes));

            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要回复的消息");
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write(scanner.next().getBytes());
            outputStream.flush();
        }
    }
}
