/*
 * @lc app=leetcode.cn id=124 lang=java
 * @lcpr version=30204
 *
 * [124] 二叉树中的最大路径和
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
// 与lc543类似
// dfs返回以该节点为根的最大链上节点之和，还要和0比较，避免负值节点
// max(max(root.left,root.right)+root.val,0)
// 路径之和即左右链之和+自身值 res=max(res,root.left+root.right+root.val)
// 递归边界条件:空节点的取值为0
class Solution {
    private Integer res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    private int dfs(TreeNode root){
        if(root==null)
            return 0;
        int lVal = dfs(root.left);// 左链和
        int rVal = dfs(root.right);// 右链和
        res = Math.max(res, lVal+rVal+root.val);// 路径和
        return Math.max(Math.max(lVal, rVal)+root.val, 0);// 返回以root为根的最大链和
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [-10,9,20,null,null,15,7]\n
// @lcpr case=end

 */

