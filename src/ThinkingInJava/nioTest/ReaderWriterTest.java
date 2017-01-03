package ThinkingInJava.nioTest;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangxh on 16-11-15.
 * package ThinkingInJava.nioTest
 * des
 */
public class ReaderWriterTest {
    public static void main(String[] args) throws IOException {
        final int BSIZE = 1024;
        String fileName = "/home/stormaroon/Files/gitrepo/oh-my-zsh/LICENSE.txt";
        FileChannel in = new FileInputStream(fileName).getChannel();
        FileChannel out = new FileOutputStream("/home/stormaroon/licenseCopy.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while ((in.read(buffer) != -1)) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
        in.close();
        out.close();
    }
}
