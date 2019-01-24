package nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Buffer的Scattering 以及 Gathering
 * Scattering 指分散
 * Gathering 指聚合
 *
 * 将来自一个channel的数据读取到多个buffer当中
 */
public class ScatteringAndGathering {

    public static void main(String[] args) throws IOException {

        ServerSocketChannel open = ServerSocketChannel.open();
        InetSocketAddress inetAddress = new InetSocketAddress(8899);

        open.socket().bind(inetAddress);

        int maxMessageLenth = 2 + 3 + 4;

        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);

        SocketChannel accept = open.accept();

        while (true) {
            int byteRead = 0;
            while (byteRead < maxMessageLenth) {
                long read = accept.read(byteBuffers);
                byteRead += read;
                System.out.println("byteRead: " + byteRead);

                for (ByteBuffer byteBuffer : byteBuffers) {
                    System.out.println("position:" + byteBuffer.position() +". limit:" + byteBuffer.limit());
                }
            }

            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.flip();
            }

            int byteWritten = 0;
            while (byteWritten < maxMessageLenth) {
                long write = accept.write(byteBuffers);
                byteWritten += write;
                System.out.println("byteWritten: " + byteWritten);
            }

            for (ByteBuffer byteBuffer : byteBuffers) {
                byteBuffer.clear();
            }
            System.out.println("maxMessageLenth: " + maxMessageLenth +
                    ", byteRead :" + byteRead + ", byteWritten：" + byteWritten);
        }
    }
}
