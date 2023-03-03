package com.zx.easy.找到所有数组中消失的数字448;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] tmp = new boolean[nums.length + 1];
        for (int num : nums) {
            tmp[num] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!tmp[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
