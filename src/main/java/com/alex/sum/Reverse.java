package com.alex.sum;

/**
 * description: 翻转整数
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * author: chenshoujiang
 * date: 2019/12/26
 */
public class Reverse {

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }

    /**
     * 算法：
     *
     * 在int中
     *                  123/10 = 12     123%10 = 3      0*10+3 = 3
     *                  12/10 = 1       12%10 = 2       3*10+2 = 32
     *                  1/10 = 0        1%10 = 1        32*10+1=321
     *
     * 在比如 120
     *
     *                  120/10 = 12     120%10=0        0*10+0=0
     *                  12/10 = 1       12%10=2         0*10+2=2
     *                  1/10 = 0        1%10=1          2*10+1=21
     *
     * 看到上面的规律没有？
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result*10 + x%10;
            x /= 10;
        }

        return Integer.MIN_VALUE>result||Integer.MAX_VALUE<result?0:(int)result;
    }
}
