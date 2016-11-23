package DataStructure;

import java.util.Random;

/**
 * Created by wangxh on 16-11-19.
 * package DataStructure
 * des
 */
public class MyLinkedList<T> {

    private Node<T> header = new Node<>(null, null);
    private int length;

    public MyLinkedList() {
        header.next = header;
    }

    private class Node<T> {
        T element;
        Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    '}';
        }
    }

    public void add(T t) {
        if (t == null) throw new NullPointerException();
        Node<T> newNode = new Node<>(t, header);
        if (header.next == header) {
            header.next = newNode;
        } else {
            for (Node<T> curr = header;;curr = curr.next) {
                if (curr.next == header) {
                    curr.next = newNode;
                    break;
                }
            }
        }
        length++;
    }

    public void add(T t, int index) {
        if (index < 0 || index > length) throw new IndexOutOfBoundsException();
        if (t == null) throw new NullPointerException();
        int count = 0;
        for (Node<T> curr = header;; curr = curr.next) {
            if (count == index) {
                curr.next = new Node<>(t, curr.next);
                break;
            }
            count++;
        }
        length++;
    }

    public T get(int index) {
        if (index < 0 || (index != 0 && index >= length)) throw new IndexOutOfBoundsException();
        int count = 0;
        for (Node<T> curr = header.next; count < length; curr = curr.next) {
            if (count == index) return curr.element;
            count++;
        }
        return null;
    }

    public T remove(int index) {
        if (index < 0 || (index >= length && index != 0)) throw new IndexOutOfBoundsException();
        int count = 0;
        Node<T> last = header.next;
        for (Node<T> curr = header.next; count < length; curr = curr.next) {
            if (count == index) {
                last.next = curr.next;
                length--;
                return curr.element;
            }
            last = curr;
            count++;
        }
        return null;
    }

    public int size() {
        return this.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int count = 0;
        for (Node<T> curr = header.next;count < length;curr = curr.next) {
            result.append(curr.toString());
            count++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");
        linkedList.add("4");
        linkedList.add("5");
        System.out.println(linkedList.size());
        System.out.println(linkedList);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(linkedList.size() - 1));
        linkedList.remove(new Random().nextInt(linkedList.size() - 1));
        System.out.println(linkedList);
    }

}
