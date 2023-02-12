package com.zx.medium.盛最多水的容器11;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int  maxArea = 0;
        while(left < right) {
            int minHeight = Math.min(height[left],height[right]);
            int  area = (right - left) * Math.min(height[left],height[right]);
            maxArea = Math.max(area,maxArea);
             while(left < right && height[left] <= minHeight){
            left++;
        }
         while(left < right && height[right] <= minHeight){
            right--;
        }
        }
       return maxArea;
    }
}