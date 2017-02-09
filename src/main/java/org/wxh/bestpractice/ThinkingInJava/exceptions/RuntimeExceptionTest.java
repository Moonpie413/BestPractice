package org.wxh.bestpractice.ThinkingInJava.exceptions;

/**
 * Created by llwxg on 2016/11/23.
 */
public class RuntimeExceptionTest {
    private void runExceptionMaker() {
        throw new RuntimeException("this is a runtime exception");
    }

    public void catchTest() {
        try {
            this.runExceptionMaker();
        } catch (RuntimeException e) {
            System.out.println("can not catch a runtime exception");
        }
    }

    public static void main(String[] args) {
        RuntimeExceptionTest test = new RuntimeExceptionTest();
        test.catchTest();
    }
}

