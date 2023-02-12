package com.zx.easy.验证回文串II680;

/**
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 *
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 *
 * 输入：s = "abc"
 * 输出：false
 */
class Solution {


    //以不允许删除字符时的双指针验证回文子串的算法为基础，在允许最多删除一个字符的情况下，同样可以使用双指针，通过贪心实现。
    //初始化两个指针 left和 right分别指向字符串的第一个字符和最后一个字符。
    //每次判断两个指针指向的字符是否相同，如果相同，则更新指针，将 left 加 1，right减 1，然后判断更新后的指针范围内的子串是否是回文字符串。
    //如果两个指针指向的字符不同，则两个字符中必须有一个被删除，
    //此时就分成两种情况：即删除左指针对应的字符，留下子串 s[left+1:right]
    //或者删除右指针对应的字符，留下子串 s[left:right−1]。当这两个子串中至少有一个是回文串时，就说明原始字符串删除一个字符之后就以成为回文串。

   public boolean validPalindrome(String s) {
       int left = 0;
       int right = s.length() -1;
       while(left < right) {
        if(s.charAt(left) == s.charAt(right)) {
           left++;
           right--;
       }else {
           return validPalindrome(s,left + 1,right) || validPalindrome(s,left,right -1);
       }
    }
    return true;
}

    private boolean validPalindrome(String s,int left,int right){
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}