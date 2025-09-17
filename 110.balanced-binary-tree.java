/*
 * @lc app=leetcode.cn id=110 lang=java
 * @lcpr version=30204
 *
 * [110] 平衡二叉树
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
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }
    public int getHeight(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight = getHeight(root.left);
        if(leftHeight==-1)
            return -1;
        int rightHeight = getHeight(root.right);
        if(rightHeight==-1)
            return -1;
        if(Math.abs(leftHeight-rightHeight) > 1)
            return -1;
        return Math.max(leftHeight,rightHeight) + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,3,3,null,null,4,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

