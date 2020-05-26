package com.alex.string;

/**
 * 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 *
 * 所有输入只包含小写字母 a-z
 *
 * 二分查找法
 */
public class LongestCommonPrefix3 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        // 查找最段字符串的长度
        for (String str: strs) {
            minLen = Math.min(str.length(), minLen);
        }

        int low = 1;
        int high = minLen;
        // 二分查找法开始查找
        while (low <= high) {
            int middle = (low + high) / 2;
            // 比较前面截取的字符串是否为公共字符串，如果是，加一个字符，如果不是，减一个字符
            if(isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    public static boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for(int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
