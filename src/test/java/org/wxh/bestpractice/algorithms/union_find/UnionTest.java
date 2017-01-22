package org.wxh.bestpractice.algorithms.union_find;

import edu.princeton.cs.algs4.Stopwatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wxh.bestpractice.algorithms.union_find.impl.QuickFind;
import org.wxh.bestpractice.algorithms.union_find.impl.QuickUnion;
import org.wxh.bestpractice.algorithms.union_find.impl.UnionFind;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by maroon on 17-1-22.
 * DES:
 */
public class UnionTest {

    private IUnion union;
    private Scanner scanner;

    @Before
    public void init() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        this.scanner = new Scanner(classLoader.getResourceAsStream("largeUF.txt"), StandardCharsets.UTF_8.toString());
    }

    @Test
    public void testQuickFind() {
        Stopwatch stopwatch = new Stopwatch();
        this.union = new QuickFind(scanner.nextInt());
        run();
        System.out.printf("QuickFind 用时 %f 秒", stopwatch.elapsedTime());
    }

    @Test
    public void testQuickUnion() {
        Stopwatch stopwatch = new Stopwatch();
        this.union = new QuickUnion(scanner.nextInt());
        run();
        System.out.printf("QuickUnion 用时 %f 秒", stopwatch.elapsedTime());
    }

    @Test
    public void testUnionFind() {
        Stopwatch stopwatch = new Stopwatch();
        this.union = new UnionFind(scanner.nextInt());
        run();
        System.out.printf("UnionFind 用时 %f 秒", stopwatch.elapsedTime());
    }

    private void run() {
        while (scanner.hasNext()) {
            int q = scanner.nextInt();
            int p = scanner.nextInt();
            if (union.connected(q, p)) continue;
            union.union(p, q);
            System.out.println("link: " + p + " and " + q);
        }
        System.out.println("Union Left: " + union.count());
    }

    @After
    public void after() {
        this.scanner.close();
    }

}