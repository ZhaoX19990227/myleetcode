package com.zx.medium.排序数组912;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 */
class Solution {
    public int[] sortArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1; 
        partition(nums,low,high);
        return nums;
    }
    public static void partition(int[] nums,int low,int high) {
        if(low >= high) return;
        int index = low;
        int privor = nums[high];
        for(int i = low;i < high;i++) {
            if(nums[i] < privor) {
                swap(nums,i,index);
                index++;
            }
        }
        swap(nums,index,high);
        partition(nums,low,index - 1);
        partition(nums,index + 1,high);
    }

    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}