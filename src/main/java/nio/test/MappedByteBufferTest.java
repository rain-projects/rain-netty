package nio.test;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer将文件映射到内存当中
 * @author rain
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile accessFile = new RandomAccessFile("mapperdtest.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(1, (byte) 'a');
        map.put(3, (byte) 'b');

        channel.close();
    }

}
