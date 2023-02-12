package com.zx.pow;

/**
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000  ....
 */
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = Math.abs(n); i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
} 