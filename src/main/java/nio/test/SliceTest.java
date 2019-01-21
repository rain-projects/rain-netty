package nio.test;

import java.nio.ByteBuffer;

/**
 * 共享子序列
 * @author: wangrui
 */
public class SliceTest {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(10);
        for (int i = 0; i < allocate.capacity(); i++) {
            allocate.put((byte) i);
        }
        allocate.position(2);
        allocate.limit(6);
        ByteBuffer slice = allocate.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            slice.put(i, (byte) (b * 2));
        }
        allocate.position(0);
        allocate.limit(allocate.capacity());
        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
    }
}
