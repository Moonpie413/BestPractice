package DataStructure;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wangxh on 16-11-20.
 * package DataStructure
 * des
 */
public class MyLinkedStack<T> {
    private StackNode<T> top;
    private int length;

    private class StackNode<T> {
        T element;
        StackNode<T> next;

        public StackNode(T element, StackNode<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    public void push(T t) {
        if (this.top == null) {
            this.top = new StackNode<>(t, null);
        } else {
            this.top = new StackNode<>(t, top);
        }
        this.length++;
    }

    public T pop() {
        if (this.length > 0 && this.top != null) {
            StackNode<T> result = this.top;
            this.top = this.top.next;
            this.length--;
            return result.element;
        }
        return null;
    }

    public int size() {
        return this.length;
    }

    @Test
    public void test() {
        MyLinkedStack stack = new MyLinkedStack();
        Assert.assertNull(stack.pop());
        stack.push("1");
        stack.push("2");
        Assert.assertEquals("2", stack.pop());
        Assert.assertEquals("1", stack.pop());
        Assert.assertNull(stack.pop());
    }
}
