package com.zx.easy.有效的括号20;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if('{' == c) {
             stack.push('}');   
            }else if('(' == c) {
                stack.push(')');
            }else if('[' == c) {
                stack.push(']');
            }else if(stack.isEmpty() || c!=stack.peek()) {
                return false;
            }else 
            stack.pop();
        }
        return stack.isEmpty();
    }
}