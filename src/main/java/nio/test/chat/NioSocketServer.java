package nio.test.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NioSocketServer {

    private static Map<String, SocketChannel> channelMap = new HashMap<String,SocketChannel>();

    public static void main(String[] args) throws IOException {

        //第一步 创建ServerSocketChannel对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //获取服务器Socket对象,并绑定相应端口
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8989));

        //将ServerSocketChannel对象注册到selector当中
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //调用选择器的select()方法,阻塞等accept事件触发,也就是客户端连接
            selector.select();

            //一旦建立链接,就可以从selector当中获取channel对象
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                //判断当前通过select的channel的处于何种事件
                if (selectionKey.isAcceptable()) {
                    //如果处于accept事件;获取channel,在这中事件下我们只向selector中注册了ServerSocketChannel对象
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                    //获取客户端的channel
                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    //将客户端连接的channel注册到selector当中;并申明监听事件为可读取状态
                    //此处的可读取事件表示客户端向服务器写入数据,服务端处于可读事件状态
                    socketChannel.register(selector, SelectionKey.OP_READ);

                    //生成key以用于群发
                    String key = "[" + UUID.randomUUID().toString() + "]";
                    System.out.println(key + " 上线!");
                    channelMap.put(key, socketChannel);
                } else if (selectionKey.isReadable()) {

                    //如果selectionKey为可读取事件状态,则获取selector中的channel对象;该状态下只注册了SocketChannel对象
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

                    //申明ByteBuffer对象
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    //从channel中读取客户端消息到buffer对象当中
                    int readByte = socketChannel.read(byteBuffer);
                    if (readByte <= 0) {
                        break;
                    }

                    //反转以用于写
                    byteBuffer.flip();

                    //获取客户端所发送的数据
                    Charset charset = Charset.forName("utf-8");
                    String clientMsg = String.valueOf(charset.decode(byteBuffer).array());

                    String sendMsgId = "";

                    for (Map.Entry<String, SocketChannel> sc : channelMap.entrySet()) {
                        if (sc.getValue() == socketChannel) {
                            sendMsgId = sc.getKey();
                        }
                    }
                    //循环向map中的所有channel发送数据;由于当byteBuffer被写完之后则该buffer中的数据就为空
                    //所以再次需要循环创建buffer对象进行写操作
                    for (Map.Entry<String, SocketChannel> sc : channelMap.entrySet()) {
                        ByteBuffer clientBuffer = ByteBuffer.allocate(1024);
                        clientBuffer.put((sendMsgId + ":" + clientMsg).getBytes());
                        clientBuffer.flip();
                        sc.getValue().write(clientBuffer);
                    }
                }
            }
            //在这些事件处理完毕之后将该其清空
            selectionKeys.clear();
        }
    }
}
