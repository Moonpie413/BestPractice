package ThinkingInJava.generics.test8;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by wangxh on 16-11-5.
 * package ThinkingInJava.generics.test8
 */

interface Generator<T> {
    T next();
}

class Character {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + id;
    }
}

class BruceWayne extends Character {}

class JonSnow extends Character{}

class Pokemon extends Character{}

public class StoryCharacters implements Generator<Character>, Iterable<Character>{

    private Random random = new Random(47);
    private Class[] types = {BruceWayne.class, JonSnow.class, Pokemon.class};
    private int size = 0;

    public StoryCharacters() {}

    public StoryCharacters(int size) {
        this.size = size;
    }

    class StoryIterator implements Iterator<Character> {

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Character next() {
            if (count == 0) throw new RuntimeException("size = 0!!!");
            count--;
            // A.this访问当前内部类的外部类的对象
            return StoryCharacters.this.next();
        }
    }

    @Override
    public Character next() {
        try {
            return (Character) types[random.nextInt(types.length)].newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator iterator() {
        return new StoryIterator();
    }

    public static void main(String[] args) {
        StoryCharacters storyCharacters = new StoryCharacters();
        for (int i=0;i<5;i++) {
            System.out.println(storyCharacters.next());
        }
//        for (Character character : new StoryCharacters(5)) {
//            System.out.println(character);
//        }
        while (new StoryCharacters(6).iterator().hasNext()) {
            System.out.println();
        }

    }
}
