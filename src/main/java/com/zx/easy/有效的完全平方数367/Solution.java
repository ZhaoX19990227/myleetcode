package com.zx.easy.有效的完全平方数367;

/**
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 *
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 *
 * 不能使用任何内置的库函数，如  sqrt 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * 示例 2：
 *
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 */
class Solution {
    public static boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // int product = mid * mid;   越界
            int t = num / mid;
            if (t == mid) {
                if (num % mid == 0) {
                    return true;
                }
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}