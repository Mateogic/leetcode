/*
 * @lc app=leetcode.cn id=1123 lang=java
 * @lcpr version=30204
 *
 * [1123] 最深叶节点的最近公共祖先
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 前置题目:lc236 二叉树的最近公共祖先
    // 如果要找的节点只在左子树中，那么最近公共祖先也只在左子树中。
    // 如果要找的节点只在右子树中，那么最近公共祖先也只在右子树中。
    // 如果要找的节点左右子树都有，那么最近公共祖先就是当前节点。
// 对于本题，如果左子树深度大于右子树，则最深叶子节点只在左子树，即最近公共祖先只在左子树，反之类似。
// 若左右子树的深度一样且均为最大深度，则当前节点即为最近公共祖先
// 特殊情况:有且仅有一个最深叶子节点，该最深节点即为所求
// 递当前节点的深度，归当前子树最深空节点的深度
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
    TreeNode res;
    int maxdepth = -1;// 全局最大深度
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // depth为当前节点的深度
        dfs(root,0);// 根节点深度为0
        return res;
    }
    // 找出以node为根的树下最深空节点的深度
    private int dfs(TreeNode node,int depth){
        if(node==null){
            maxdepth = Math.max(maxdepth,depth);// 维护最大深度
            return depth;
        }
        int left = dfs(node.left, depth+1);// 左子树最深空节点的深度
        int right = dfs(node.right,depth+1);// 右子树最深空节点的深度
        if(left==right && left==maxdepth)// 左右子树都有最深的根节点
            res = node;// 所求最近公共祖宗节点
        return Math.max(left,right);// 以node为根最深空节点的深度
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,3,null,2]\n
// @lcpr case=end

 */

