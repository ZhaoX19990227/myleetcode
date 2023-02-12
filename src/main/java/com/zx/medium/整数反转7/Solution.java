package com.zx.medium.整数反转7;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 */
class Solution {
    public int reverse(int x) {
        int result = 0;
        while(x != 0) {
            int temp = result;
            result = (result * 10) + (x % 10);
            x /= 10;
            if(result / 10 != temp) return 0;
        }
        return result;
    }
}