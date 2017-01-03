package ThinkingInJava.DataStructure;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by wangxh on 16-11-21.
 * package ThinkingInJava.DataStructure
 * des 二分查找
 */
public class BinarySearchTest {
    private int[] data;

    private static class Generator {
        public static int next() {
            return new Random().nextInt(100);
        }
    }

    public BinarySearchTest(int[] data) {
        this.data = data;
        Arrays.sort(this.data);
        System.out.println("sorted: " + Arrays.toString(this.data));
    }

    public int binarySearch(int target) {
        int left = 0, right = data.length - 1, mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target > data[mid]) left = mid + 1;
            else if (target < data[mid]) right = mid - 1;
            else return mid;
        }
        return -1;
    }

    public int binarySearchLoop(int left, int right, int target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (target > data[mid]) return binarySearchLoop(mid + 1, right, target);
        else if (target < data[mid]) return binarySearchLoop(left, mid - 1, target);
        return mid;
    }

    public static void main(String[] args) {
        int[] testdata = {2,3,5,8,45,34,76,89,0,23,43};
        BinarySearchTest binarySearch = new BinarySearchTest(testdata);
        System.out.println(binarySearch.binarySearch(8));
        System.out.println(binarySearch.binarySearchLoop(0, testdata.length - 1, 9));
    }
}
