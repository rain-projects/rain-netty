package com.rain.zerocopy;

import java.io.DataInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class OldIOServer {

    public static void main(String[] args)  throws Exception {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 8899));

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            byte[] buffer = new byte[4096];

            while (true) {
                int read = dataInputStream.read(buffer);
                if (read == -1) {
                    break;
                }
            }
            dataInputStream.close();
        }
    }
}
