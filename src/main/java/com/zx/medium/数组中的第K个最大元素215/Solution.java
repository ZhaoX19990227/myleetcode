package com.zx.medium.数组中的第K个最大元素215;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int i = partition(nums,left,right);
            if(i == k) break;
            else if(i < k) left = i + 1;
            else right = i - 1; 
        }
        return nums[k];
    }
    public int partition(int nums[],int left,int right) {
        int i = left;
        int privor = nums[right];
        for(int j = left;j < nums.length;j++) {
            if(nums[j] < privor) {
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,right);
        return i;
    }
    public void swap(int nums[],int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}