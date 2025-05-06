/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30204
 *
 * [17] 电话号码的字母组合
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private String[] phoneMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private List<String> res = new ArrayList<>();
    private StringBuilder cur = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length() == 0)
            return res;
        dfs(0,digits);
        return res;
    }
    // 尝试从索引i填充cur字符串
    private void dfs(int i, String digits){
        if(i==digits.length()){// 已经填好从0到digits.length()-1共digits.length()个字母
            res.add(cur.toString());// 收集该方案
            return ;
        }
        int digit = digits.charAt(i) - '0';// 获取当前位置的数字
        String letters = phoneMap[digit];// 映射到可能填入的字母
        for(int j = 0;j<letters.length();j++){// 尝试用各种可能的字母填充该位置
            cur.append(letters.charAt(j));
            dfs(i+1, digits);
            cur.deleteCharAt(cur.length()-1);// 恢复现场
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */

