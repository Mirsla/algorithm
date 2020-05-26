package com.alex.string;

import java.util.HashMap;
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
public class LongestCommonPrefix2 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Tire trie = new Tire();
        for (String str : strs) {
            trie.insert(str);
        }
        return trie.searchLongestPrefix(strs[0]);
    }

    static class TireNode {
        private TireNode[] links;
        // links的最大长度
        private final int R = 26;
        private boolean isEnd;
        private int size;

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
            size++;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public int size() {
            return size;
        }
    }

    static class Tire {
        private TireNode root;

        public Tire() {
            root = new TireNode();
        }

        public void insert(String word) {
            TireNode node = root;
            for(int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TireNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        public String searchLongestPrefix(String word) {
            TireNode node = root;
            StringBuilder prefix = new StringBuilder();

            for(int i = 0; i < word.length(); i++) {
                char charLetter = word.charAt(i);
                if(node.containsKey(charLetter) && (node.size() == 1) && !node.isEnd()) {
                    prefix.append(charLetter);
                    node=node.get(charLetter);
                } else {
                    return prefix.toString();
                }
            }

            return prefix.toString();
        }

        public boolean search(String word) {
            TireNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        private TireNode searchPrefix(String word) {
            TireNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter)) {
                    node = node.get(curLetter);
                } else {
                    return null;
                }
            }
            return node;
        }
    }
}
