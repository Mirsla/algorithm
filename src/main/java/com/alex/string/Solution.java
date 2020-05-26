package com.alex.string;

/**
 * description:
 * author: alex
 * date: 2019/12/31
 */
public class Solution {

    public static void main(String[] args) {
        strStr("aaa", "aaaa");
    }

    /**
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(null == haystack) {
            return -1;
        }
        if(null == needle || needle.length() ==0) {
            return 0;
        }

        char[] chars = haystack.toCharArray();
        char begin = needle.charAt(0);
        for(int i =0; i < chars.length; i++) {
            if(i + needle.length() > chars.length) {
                break;
            }
            if(begin == chars[i] && haystack.substring(i,i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
