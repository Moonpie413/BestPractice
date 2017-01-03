package ThinkingInJava.chapter17.practice8;

import java.util.NoSuchElementException;

/**
 * Created by wangxh on 16-11-10.
 * package ThinkingInJava.chapter17.practice8
 * des
 */

interface SListIterator<T> {
    boolean hasNext();
    T next();
    void add(T element);
    void remove();
}

public class SList<T> {

    private final Link<T> header = new Link<>(null, null);

    public SList() {
        header.next = header;
    }

    private class Link<T> {
        T element;
        Link<T> next;

        public Link(T element, Link<T> next) {
            this.element = element;
            this.next = next;
        }
    }

    private class SListIteratorImpl implements SListIterator<T> {

        private Link<T> lastReturned = header;
        private Link<T> next;

        public SListIteratorImpl() {
            // 第一次初始化时header.next = header， 第二次初始化后把next指向header的下一个元素
            this.next = header.next;
        }

        @Override
        public boolean hasNext() {
            return this.next != header;
        }

        @Override
        public void remove() {
            if (lastReturned == header) throw new IllegalStateException();
            for (Link<T> curr = header; ;curr = curr.next) {
                if (curr.next == lastReturned) {
                    curr.next = lastReturned.next;
                    break;
                }
                lastReturned = header;
            }
        }

        @Override
        public T next() {
            if (next == header) throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            return lastReturned.element;
        }

        @Override
        public void add(T element) {
            lastReturned = header;
            Link<T> newLink = new Link<>(element, next);
            if (header.next == header) {
                header.next = newLink;
            } else {
                for (Link<T> curr = header;;curr = curr.next)
                    // 判断next是否为初始化时的next
                    if (curr.next == next) {
                        curr.next = newLink;
                        break;
                    }
            }
        }
    }

    public SListIterator iterator() {
        return new SListIteratorImpl();
    }

    public static void main(String[] args) {
        SList<String> sList = new SList<>();
        SListIterator iterator = sList.iterator();
        iterator.add("hello");
        iterator.add("world");
        iterator.add("agein");
        iterator.add("and");
        iterator = sList.iterator();
        System.out.println(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.remove();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ",");
        }
    }

}
