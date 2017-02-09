package org.wxh.bestpractice.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by wangxh on 16-11-19.
 * package org.wxh.bestpractice.codewars
 * des
 */
public class FindOutlier {
    static int find(int[] integers) {
        int oddcount = 0;
        int evencount = 0;
        boolean flag = false;
        for (int i = 0; i < 3; i++) {
        }

        return 0;
    }

    static int findByflag(boolean flag, int[] integers) {
        int condition = 0;
        if (flag) condition = 1;
        for (int i = 3; i < integers.length; i++) {
            if (i % 2 == condition) {

            }
        }
        return 0;
    }

    @Test
    public void test() {
        int[] exampleTest1 = {2, 6, 8, -10, 3};
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, FindOutlier.find(exampleTest1));
        assertEquals(206847684, FindOutlier.find(exampleTest2));
        assertEquals(0, FindOutlier.find(exampleTest3));
    }
}
