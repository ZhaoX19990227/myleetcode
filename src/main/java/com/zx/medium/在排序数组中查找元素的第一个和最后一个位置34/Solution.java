package com.zx.medium.在排序数组中查找元素的第一个和最后一个位置34;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int left = search(nums, target);
        int right = search(nums, target + 1);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right - 1};
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}