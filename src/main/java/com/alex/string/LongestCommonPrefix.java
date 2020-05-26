package com.alex.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
 * 采用前缀树  tire来完成
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"","b"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        Tire tire = new Tire();
        for(String str: strs) {
            insertNode(str, tire);
        }

        return findMaxPrefix(tire, strs);
    }

    public static void insertNode(String str, Tire head) {
        if(str == null) {
            return;
        }
        Tire cur = head; // 当前操作的节点
        // 解决"" 空字符串无法存入的问题
        if("".equals(str)) {
            if (!cur.children.containsKey((char) 32)) {
                // 如果当前节点的children中包含了这个字符
                cur.children.put((char) 32, new Tire());
            }

            return;
        }

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (!cur.children.containsKey(aChar)) {
                // 如果当前节点的children中包含了这个字符
                cur.children.put(aChar, new Tire());
            }
            // 跳转到下一个节点
            cur = cur.children.get(aChar);
        }
    }

    public static String findMaxPrefix(Tire head, String[] strings) {
        if(null == strings || strings.length == 0) {
            return "";
        }
        // 最长多少字符串
        int min = strings[0].length();
        for(int i = 1; i < strings.length; i++) {
            if(strings[i].length() < min) {
                min = strings[i].length();
            }
        }

        StringBuilder maxPrefix = new StringBuilder();
        Tire cur = head;
        int count = 0;
        while (cur != null && cur.children != null && cur.children.size() == 1 && count < min) {
            Set<Character> keys = cur.children.keySet();
            for (Character next : keys) {
                maxPrefix.append(next);
            }
            count++;
            cur = cur.children.get(maxPrefix.charAt(maxPrefix.length() - 1));
        }

        return maxPrefix.toString().trim();
    }

    static class Tire {
        Map<Character, Tire> children = new HashMap<>();
    }

    static class TireNode {
        private TireNode[] links;
        // links的最大长度
        private final int R = 26;
        private boolean isEnd;

        public TireNode() {
            links = new TireNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TireNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TireNode tireNode) {
            links[ch - 'a'] = tireNode;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
