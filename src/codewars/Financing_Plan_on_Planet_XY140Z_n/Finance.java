package codewars.Financing_Plan_on_Planet_XY140Z_n;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

/**
 * Created by wangxh on 16-12-19.
 * Package codewars
 * DES: I need to save some money to buy a gift. I think I can do something like that:

 First week (W0) I save nothing on Sunday, 1 on Monday, 2 on Tuesday... 6 on Saturday, second week (W1) 2 on Monday... 7 on Saturday and so on according to the table below where the days are numbered from 0 to 6.

 Can you tell me how much I will have for my gift on Saturday evening after I have saved 12? (Your function finance(6) should return 168 which is the sum of the savings in the table).

 Imagine now that we live on planet XY140Z-n where the days of the week are numbered from 0 to n (integer n > 0) and where I save from week number 0 to week number n included (in the table below n = 6).

 How much money would I have at the end of my financing plan on planet XY140Z-n?
 */

public class Finance {
    public static BigInteger finance(int n) {
        BigInteger result = BigInteger.valueOf(0);
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= i * 2; j++) {
                result = result.add(BigInteger.valueOf(j));
            }
        }
        return result;
    }
    @Test
    public void test1() {
        assertEquals(BigInteger.valueOf(105), Finance.finance(5));
    }
    @Test
    public void test2() {
        assertEquals(BigInteger.valueOf(168), Finance.finance(6));
    }
    @Test
    public void test3() {
        assertEquals(BigInteger.valueOf(360), Finance.finance(8));
    }
    @Test
    public void test4() {
        assertEquals(BigInteger.valueOf(2040), Finance.finance(15));
    }
}
