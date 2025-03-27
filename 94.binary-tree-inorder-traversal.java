/*
 * @lc app=leetcode.cn id=94 lang=java
 * @lcpr version=30204
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder_recursion(root, res);
        // inorder_iteration(root, res);
        return res;
    }
    // 递归
    private void inorder_recursion(TreeNode root, List<Integer> res){
        if (root==null) 
            return ;
        inorder_recursion(root.left, res);
        res.add(root.val);
        inorder_recursion(root.right, res);
    }
    // 迭代
    private void inorder_iteration(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (!stk.isEmpty() || cur!=null) {
            while (cur!=null) {// 找到二叉树的左下角节点
                stk.push(cur);
                cur = cur.left;
            }// 出循环后左下角节点为栈顶元素
            TreeNode node = stk.pop();
            res.add(node.val);
            if (node.right!=null)
                cur = node.right;     
        }
    }

}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

