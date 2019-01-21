package nio.test;

import java.nio.ByteBuffer;

/**
 * @author: wangrui
 */
public class ReadOnlyTest {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.getClass());
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        System.out.println(readOnlyBuffer.getClass());
        readOnlyBuffer.position(0);
//        readOnlyBuffer.put((byte) 2); //throws ReadOnlyBufferException
    }

}
