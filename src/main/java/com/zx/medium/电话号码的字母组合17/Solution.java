package com.zx.medium.电话号码的字母组合17;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
class Solution {
    String[] mappings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == "") return res;
        dfs(digits,0,new StringBuilder());
        return res;
    }
    private void dfs(String digits,int index,StringBuilder sb) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int num = Integer.valueOf(String.valueOf(digits.charAt(index)));
        for(int i = 0;i < mappings[num].length();i++) {
            sb.append(mappings[num].charAt(i));
            dfs(digits,index + 1,sb);
            sb.deleteCharAt(index);
        }
    }
}                                                                                   