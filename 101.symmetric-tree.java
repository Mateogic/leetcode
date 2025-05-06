/*
 * @lc app=leetcode.cn id=101 lang=java
 * @lcpr version=30204
 *
 * [101] 对称二叉树
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
// 与lc100相同的树类似，判断根节点的左右子树是否对称即可
// 相同和对称的区别在于:相同分别判断左子树和左子树相同，右子树和右子树相同；对称分别判断左子树和右子树相同，右子树和左子树相同
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }
    public boolean isSameTree(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        else if(left==null || right==null)
            return false;
        else if(left.val != right.val)
            return false;
        else
            return isSameTree(left.left, right.right) && isSameTree(left.right, right.left);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,3,4,4,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,null,3,null,3]\n
// @lcpr case=end

 */

