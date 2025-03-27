/*
 * @lc app=leetcode.cn id=145 lang=java
 * @lcpr version=30204
 *
 * [145] 二叉树的后序遍历
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Collections;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // postorder_recursion(root, res);
        postorder_iteration(root, res);
        return res;
    }
    // 递归
    private void postorder_recursion(TreeNode root, List<Integer> res){
        if (root==null) 
            return ;
        postorder_recursion(root.left, res);
        postorder_recursion(root.right, res);
        res.add(root.val);
    }
    // 迭代
    private void postorder_iteration(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.left!=null)
                stk.push(node.left);
            if (node.right!=null) 
                stk.push(node.right);
        }
        // 翻转
        Collections.reverse(res);
    }
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

