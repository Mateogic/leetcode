/*
 * @lc app=leetcode.cn id=230 lang=java
 * @lcpr version=30204
 *
 * [230] 二叉搜索树中第 K 小的元素
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

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
// 二叉搜索树的中序遍历满足严格升序规则
// 所求第k小的元素即为中序遍历第k个遍历到的元素
class Solution {
    private int idx = 1;
    private int res = -1;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    public void dfs(TreeNode root,int k){
        if(root==null)
            return;
        dfs(root.left,k);
        if(idx++==k){
            res = root.val;
            return ;
        }
        dfs(root.right,k);

    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,1,4,null,2]\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,3,6,2,4,null,null,1]\n3\n
// @lcpr case=end

 */

