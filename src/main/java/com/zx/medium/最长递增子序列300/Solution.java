package com.zx.medium.最长递增子序列300;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int res = 1;
        int[] dp = new int[len];
        //初始化数据
        Arrays.fill(dp, 1);
        //i从1开始 j从0开始
        //保证i每次移动都和j前面所有元素进行比较，获取最终的最大值
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }
}