package org.wxh.bestpractice.codewars;

/**
 * Created by wangxh on 16-11-19.
 * package org.wxh.bestpractice.codewars
 * des
 */
public class CreatePhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder result = new StringBuilder("(");
        for (int i = 0; i < numbers.length; i++) {
            result.append(numbers[i]);
            if (i == 2) result.append(") ");
            if (i == 5) result.append("-");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(CreatePhoneNumber.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
