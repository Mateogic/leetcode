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
import java.util.Stack;
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
        // preorder_recursion(root,res);// 递归
        preorder_iteration(root,res);// 迭代
        return res;
    }
    // 递归
    private void preorder_recursion (TreeNode root, List<Integer> res){
        if (root==null) 
            return;
        res.add(root.val);
        preorder_recursion(root.left, res);
        preorder_recursion(root.right, res);
    }

    // 迭代
    private void preorder_iteration (TreeNode root, List<Integer> res){
        if (root==null) 
            return ;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();// 取出根结点
            res.add(node.val);
            if(node.right!=null)// 先右节点入栈
                stk.push(node.right);
            if(node.left!=null)// 后左节点入栈
                stk.push(node.left);
        }
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

