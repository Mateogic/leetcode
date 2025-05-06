/*
 * @lc app=leetcode.cn id=78 lang=java
 * @lcpr version=30204
 *
 * [78] 子集
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 考虑lc78子集与lc46全排列的差异
    // 全排列：考虑元素的排列顺序，长度固定为n
    // 子集：只考虑元素是否被选择，长度从0到n不等

    // 全排列：需要标记哪些元素已被使用(selected数组)
    // 子集：使用索引i避免重复选择，无需标记数组

    // 全排列：只有当所有位置都填满时才添加到结果集
    // 子集：每次递归都将当前集合加入结果集，因为每个状态都是合法子集

    // 全排列需要显式边界条件i == nums.length，子集无需该条件
        // 全排列只有填满所有位置（达到长度n）时才是一个有效解
        // 全排列边界条件是递归终止和添加结果的必要条件


        // 子集每个中间状态都是有效解，所以无论长度如何都要添加
        // 子集当 i == nums.length 时，for循环自然不会执行（j 从 nums.length 开始，条件 j < nums.length 不满足）
        // 此时会添加当前子集到结果，然后自然返回，不需要显式检查
import java.util.List;
import java.util.ArrayList;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> cur = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }
    
    // 从nums[i]开始考虑哪些元素加入子集
    private void dfs(int i, int[] nums) {
        // 当前路径形成的集合就是一个子集，直接加入结果
        res.add(new ArrayList<>(cur));
        
        // 尝试在当前子集基础上添加新元素形成更大子集
        for (int j = i; j < nums.length; j++) {// 更换索引i处的元素
            cur.add(nums[j]);
            dfs(j + 1, nums); // 递归追加处理下一个位置的元素
            cur.remove(cur.size() - 1); // 恢复现场，进入下一循环更换索引i处为其它元素
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

