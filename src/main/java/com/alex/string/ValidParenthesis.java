package com.alex.string;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 */
public class ValidParenthesis {

    private final HashMap<Character, Character> keyMap;

    public ValidParenthesis() {
        keyMap = new HashMap<>();
        keyMap.put(')', '(');
        keyMap.put('}', '{');
        keyMap.put(']', '[');
    }

    public static void main(String[] args) {
        ValidParenthesis validParenthesis = new ValidParenthesis();
        String str = "(]";
        System.out.println(validParenthesis.isValid(str));
    }

    /**
     * 第一种解法，直接用栈
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        for (char ch: chars) {
            if(keyMap.containsKey(ch)) {
                // 栈顶标识(前一个元素)
                Character top = stack.empty() ? '#' : stack.pop();
                // 出栈；
                if(top != keyMap.get(ch)) {
                    return false;
                }
            } else {
                // 进栈
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
