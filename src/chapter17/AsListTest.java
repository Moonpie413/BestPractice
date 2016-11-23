package chapter17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangxh on 16-11-10.
 * package chapter17
 * des
 */
public class AsListTest {
    static int a[] = {1,2,3,4,5,6};

    public static void main(String[] args) {
        try {
            List a1 = Arrays.asList(a);
            a1.remove(0);
        } catch (Exception e) {
            List a1 = new ArrayList(Arrays.asList(a));
        }

    }
}
