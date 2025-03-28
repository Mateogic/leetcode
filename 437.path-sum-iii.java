/*
 * @lc app=leetcode.cn id=437 lang=java
 * @lcpr version=30204
 *
 * [437] 路径总和 III
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 思路类似lc560(和为k的子数组数量)前缀和+哈希
    // 在二叉树中，前缀和相当于从根节点开始的路径元素和
    // 用哈希表 cnt 统计前缀和的出现次数，递归到节点 node 时，设从根到 node 的路径元素和为 s，那么有 cnt[s−targetSum] 个符合要求的路径
    private int res;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        dfs(root, 0, targetSum, cnt);
        return res;
    }
    private void dfs(TreeNode node, long s, int targetSum, Map<Long, Integer> cnt) {
        if (node == null) 
            return;
        s += node.val;
        res += cnt.getOrDefault(s - targetSum, 0);
        cnt.put(s,cnt.getOrDefault(s, 0)+1); // cnt[s]++
        dfs(node.left, s, targetSum, cnt);
        dfs(node.right, s, targetSum, cnt);
        cnt.put(s,cnt.getOrDefault(s, 0)-1); // cnt[s]-- 恢复现场
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,5,-3,3,2,null,11,3,-2,null,1]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,4,8,11,null,13,4,7,2,null,null,5,1]\n22\n
// @lcpr case=end

 */

