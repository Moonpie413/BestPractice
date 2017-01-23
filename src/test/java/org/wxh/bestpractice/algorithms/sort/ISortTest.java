package org.wxh.bestpractice.algorithms.sort;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wxh.bestpractice.algorithms.sort.impl.BubbleSort;
import org.wxh.bestpractice.algorithms.sort.impl.InsertSort;
import org.wxh.bestpractice.algorithms.sort.impl.ShellSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by maroon on 17-1-23.
 * DES:
 */
public class ISortTest {

    Scanner scanner;
    String[] words;
    @Before
    public void init() {
        ClassLoader classLoader = getClass().getClassLoader();
        scanner = new Scanner(classLoader.getResourceAsStream("words5-knuth.txt"));
        StringBuffer allString = new StringBuffer();
        while (scanner.hasNext()) {
            allString.append(scanner.next() + " ");
        }
        words = allString.toString().split(" ");
    }
    @Test
    public void testBubbleSort() {
        ISort sort = new BubbleSort();
        sort.sort(words);
        Assert.assertTrue(sort.isSorted(words));
    }

    @Test
    public void testInsertSort() {
        InsertSort insertSort = new InsertSort();
//        insertSort.sort(words);
        insertSort.sortWithOutExch(words);
        Assert.assertTrue(insertSort.isSorted(words));
    }

    @Test
    public void testShellSort() {
        ISort shellsort = new ShellSort();
        shellsort.sort(words);
        Assert.assertTrue(shellsort.isSorted(words));
    }

    @After
    public void close() {
        scanner.close();
    }
}