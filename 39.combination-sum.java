/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30204
 *
 * [39] 组合总和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 使用dfs(i,left)回溯解决，i表示从candidates[i]开始考虑是否选择元素凑齐target，left表示剩余要选的元素之和
// 递归边界
    // 找到符合条件的组合cur，复制添加到结果res，return ;
    // 剩余要选元素之和left<0，说明当前组合之和已超过目标值，直接return ;
// 组合允许重复选择，因此下次递归仍然传参j = j

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> cur = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 原问题
        dfs(0, target, candidates);
        return res;
    }
    private void dfs(int i, int left, int[] candidates){
        // 递归边界条件
        if(left == 0){
            res.add(new ArrayList<>(cur));
            return ;
        }
        if(left < 0)
            return ;
        // 从j = i开始考虑是否选取元素
        for(int j = i;j<candidates.length;j++){
            cur.add(candidates[j]);
            // 允许重复选择
            dfs(j, left-candidates[j], candidates);
            cur.remove(cur.size()-1);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

 */

