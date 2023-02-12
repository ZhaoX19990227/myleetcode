package com.zx.medium.括号生成22;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
class Solution {
    List<String> res = new ArrayList();
    public List<String> generateParenthesis(int n) {
        dfs(n,n,"");
        return res;
    }
    private void dfs(int left,int right,String str) {
        if(left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if(left > 0) { //还有左括号剩余
            dfs(left - 1,right,str + "(");
        }
        if(right > left) {//还有右括号剩余
             dfs(left,right - 1,str + ")");
        }
    }
}