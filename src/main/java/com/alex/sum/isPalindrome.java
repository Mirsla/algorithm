package com.alex.sum;

/**
 * description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 *
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 *
 *
 *
 * author: chenshoujiang
 * date: 2019/12/26
 */
public class isPalindrome {

    public static void main(String[] args) {

        System.out.println(Math.floor(-8.5));
//        System.out.println(10^9 > 2 ^ 31);
    }

    /**
     * 方式1
     *
     * 求一个数的翻转数，如果翻转的数和原来的数字相等即可
     *
     * 可以参考
     * @see Reverse 的算法
     *
     *  @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        long result = 0;
        int target = x;
        while (x != 0) {
            result = result*10 + x%10;
            x /= 10;
        }

        return result == target;
    }

    /**
     * 第二种解法
     *
     * 如果是回文整数，读都要是一样的数意味着，两个数必须是相等的，对应的位置上的数也必须是相等的
     *
     * 举例说明： 12321 第一位和最后一位，第二位和倒数第二位
     * 如果位数是奇数，最中间的不用管，偶数，要一直相等即可
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        for(int i = 0; i < sb.length()/2; i++) {
            if(sb.charAt(i) != sb.charAt(sb.length() - i -1)) {
                return false;
            }
        }
        return true;
    }
}
