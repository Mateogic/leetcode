/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30204
 *
 * [98] 验证二叉搜索树
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
// 因此，中序遍历该二叉树，检查是否存在当前节点小于等于前个节点值（不满足升序）
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        if(!isValidBST(root.left))// 检查左子树是否满足二叉搜索树规律
            return false;
        if(root.val <= pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,4,null,null,3,6]\n
// @lcpr case=end

 */

