package com.zx.hard.寻找两个正序数组的中位数;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int left = -1, right = -1;
        int i = 0, j = 0;
        while (i + j - 1 != len / 2) {
            left = right;
            if (i < nums1.length && (j >= nums2.length || nums1[i] < nums2[j])) {
                right = nums1[i++];
            }else {
                right = nums2[j++];
            }
        }
        if (len % 2 == 0) {
            return (double) (left + right) / 2;
        }
        return right;
    }
}