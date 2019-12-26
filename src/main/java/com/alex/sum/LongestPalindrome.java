package com.alex.sum;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * author: chenshoujiang
 * date: 2019/12/26
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 解法：
     * 将字符串转换为一个字符数组， babad
     *
     *      回文的意思是：正读和反着读意思是一样的
     * b
     * ba
     * bab -> 记录 bab,移除第一个b，-> ab
     * aba -> 还是三个  移除第一个a
     * bad -> 不是回文，不满足。不记录，时间复杂度为O(n)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }

        if(s.length() == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb2.insert(0,s.charAt(i));


        }
        return result;
    }
}
