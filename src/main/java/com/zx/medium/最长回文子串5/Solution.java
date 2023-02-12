package com.zx.medium.最长回文子串5;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 */
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for(int i = 0;i < s.length();i++) {
            i = findLongestStr(str,i,range);
        }
        return s.substring(range[0],range[1] + 1);
    }
    private int findLongestStr(char[] str,int low,int[] range){
        int high = low;
        //如果下一个字符和当前字符相等 则是重复子串  右移
        while(high < str.length - 1 && str[high + 1] == str[low]) {
            high ++;
        }
        //记录当前重复子串的最后一位下标
        int ans = high;
        //中心扩散法
        while(low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
        if(high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        //返回当前重复子串的最后一个下标 这样下次开始的i就直接跳过重复的子串了
        return ans;
    }
}