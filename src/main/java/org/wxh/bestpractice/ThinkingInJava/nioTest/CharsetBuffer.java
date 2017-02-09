package org.wxh.bestpractice.ThinkingInJava.nioTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * Created by wangxh on 16-11-15.
 * package org.wxh.bestpractice.ThinkingInJava.nioTest
 * des
 */
public class CharsetBuffer {
    public static void main(String[] args) {
        String fileName = "/home/stormaroon/Files/gitrepo/oh-my-zsh/LICENSE.txt";
        try (FileChannel fc = new FileInputStream(fileName).getChannel()){
            ByteBuffer buffer = ByteBuffer.allocate(2048);
            fc.read(buffer);
            buffer.flip();
            System.out.println(Charset.forName("UTF-8").decode(buffer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
