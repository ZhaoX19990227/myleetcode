package com.zx.交换和;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 */
class Solution {
    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0, sum2 = 0;
        for (int i : array1) {
            sum1 += i;
            set.add(i);
        }
        for (int i : array2) {
            sum2 += i;
        }
        int dis = sum1 - sum2;

        if ((dis & 1) == 1) {  //if(dis % 2 != 0)
            return new int[]{};
        }
        dis /= 2;
        for (int y : array2) {
            int target = y + dis;
            if (set.contains(target)) {
                return new int[]{target, y};
            }
        }
        return new int[]{};
    }
}