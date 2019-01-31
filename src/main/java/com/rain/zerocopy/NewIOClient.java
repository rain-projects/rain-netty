package com.rain.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NewIOClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String fileName = "/Volumes/Documents/资料类/netty/46_字符集编解码全方位解析.mp4";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long startTime = System.currentTimeMillis();
        long transfer = fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        System.out.println("发送的总字节数:" + transfer + " ,耗时:" + (System.currentTimeMillis() - startTime));

        fileChannel.close();
        socketChannel.close();

    }
}
