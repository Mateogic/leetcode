/*
 * @lc app=leetcode.cn id=144 lang=java
 * @lcpr version=30204
 *
 * [144] 二叉树的前序遍历
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }
    // 递归
    private void preorder(TreeNode root, List<Integer> res){
        if (root==null) 
            return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 迭代
    // public List<Integer> preorderTraversal(TreeNode root) {
        
    // }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5,null,8,null,null,6,7,9]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

