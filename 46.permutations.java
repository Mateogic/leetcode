/*
 * @lc app=leetcode.cn id=46 lang=java
 * @lcpr version=30204
 *
 * [46] 全排列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // 标记原数组哪些 索引j 处的值被选过，允许为重复元素全排列
        boolean[] selected = new boolean[nums.length];
        dfs(0, nums, selected);// 尝试从cur(0)填到cur(nums.length-1)共nums.length个元素
        // 暴搜过程中将符合要求的方案cur加到res
        return res;
    }
    // 尝试从cur(i)填到cur(nums.length-1)
    private void dfs(int i, int[] nums, boolean[] selected) {
        if (i == nums.length) {// cur列表已填上了[0,...,i-1]共i=nums.length个元素，无需再填
            res.add(new ArrayList<>(cur));// Java为值引用，应该返回数组拷贝
            return;
        }
        // 一次深搜索引i相同，该位置选择不同的nums[j]，构成多叉搜索树的一层
        for (int j = 0; j < nums.length; j++) {
            if (!selected[j]) {// 尝试将没被选过的nums[j]填到cur(i)
                cur.add(nums[j]);
                selected[j] = true; // 标记选过
                // cur(i)填上nums[j]后，继续尝试从cur(i+1)填到cur(nums.length-1)
                dfs(i + 1, nums, selected);
                selected[j] = false; // 恢复现场，取消标记，下一轮j+=1，取消标记也不会重复选
                cur.remove(i);// 恢复现场，删除cur列表索引i处的元素
            }
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

