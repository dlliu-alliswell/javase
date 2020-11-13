package dl.alliswell.javase.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: dlliu
 * @date_time: 2020/11/12 10:24
 * @description:
 */
public class ChannelExample {
    public static void main(String[] args) throws IOException {
        URL url = ChannelExample.class.getClassLoader().getResource("nio-data.txt");
        assert url != null;
        RandomAccessFile file = new RandomAccessFile(url.getPath(), "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = channel.read(buffer);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            bytesRead = channel.read(buffer);
        }
        file.close();
    }
}
