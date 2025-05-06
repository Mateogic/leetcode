/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30204
 *
 * [114] 二叉树展开为链表
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
// 展为单链表的节点序即为前序遍历顺序
// 先前序遍历记录顺序，再按照顺序连接节点
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root,list);
        int n = list.size();
        for(int i = 1;i<n;i++){
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }
    public void dfs(TreeNode root,List<TreeNode> list){
        if(root==null)
            return ;
        list.add(root);
        dfs(root.left,list);
        dfs(root.right,list);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,5,3,4,null,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

