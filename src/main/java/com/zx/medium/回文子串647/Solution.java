package com.zx.medium.回文子串647;

/**
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 * <p>
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        //情况一：下标i与j相同，同一个字符例如a,当然是回文子串
        //情况二：下标i与j相差为1，例如aa,也是回文子串
        //情况三：下标：i与相差大于1的时候，例如cabac,此时s[i]与s[j]已经相同了，
        //i到j区间是不是回文子串就看aba是不是回文就可以了，那么aba的区间就是i+1与j-1区间，
        //这个区间是不是回文就看dp[i+1][j~1]是否为true。
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2) {
                        dp[i][j] = true;
                        ++res;
                    } else if (dp[i - 1][j + 1]) {
                        dp[i][j] = true;
                        ++res;
                    }
                }
            }
        }
        return res;
    }
}