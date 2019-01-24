package nio.test.chat;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioSocketClient {

    public static void main(String[] args) throws IOException {

        //创建客户端channel对象
        SocketChannel socketChannel = SocketChannel.open();
        //设置channel对象为非阻塞
        socketChannel.configureBlocking(false);
        //连接服务器地址端口
        socketChannel.connect(new InetSocketAddress("127.0.0.1",8989));
        //创建selector对象并注册,设置监听状态为连接状态
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        while (true) {
            //调用select方法,阻塞直到通过指定的监听事件触发
            selector.select();
            //获取selector当中的所有已注册的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                //判断事件
                if (selectionKey.isConnectable()) {
                    //如果当前事件为连接状态,获取所对应的SocketChannel对象
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    //判断当前的socket状态是否是连接准备状态
                    if (client.isConnectionPending()) {
                        //完成服务连接
                        client.finishConnect();
                        ByteBuffer allocate = ByteBuffer.allocate(1024);
                        allocate.put((LocalDateTime.now() + "连接成功").getBytes());
                        allocate.flip();
                        client.write(allocate);

                        //开启线程处理信息
                        ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                        executorService.submit(() -> {
                            while (true) {
                                try {
                                    //重置ByteBuffer对象
                                    allocate.clear();

                                    InputStreamReader isr = new InputStreamReader(System.in);
                                    BufferedReader bufferedReader = new BufferedReader(isr);
                                    String line = bufferedReader.readLine();
                                    //发送录入消息
                                    allocate.put(line.getBytes());
                                    allocate.flip();
                                    client.write(allocate);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                    //连接完成 将socket对象所注册的状态改为等待读取
                    client.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //如果通过读取的状态,代表当前socket有数据传输过来
                    SocketChannel client = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);

                    int read = client.read(readBuffer);
                    if (read > 0) {
                        String meg = new String(readBuffer.array(), 0, read);
                        System.out.println(meg);
                    }
                }
            }
            selectionKeys.clear();
        }
    }
}
