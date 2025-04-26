/*
 * @lc app=leetcode.cn id=199 lang=java
 * @lcpr version=30204
 *
 * [199] 二叉树的右视图
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
// 只需要把每层的最右侧的节点加入list
// 故按照中->右->左的顺序遍历
// 记录当前遍历的层数，与list长度比较
    // 若遍历层数=list长度，表明还未向list添加本层节点，需要添加
    // 否则不需要添加

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root,list,0);
        return list;
    }
    public void dfs(TreeNode root,List<Integer>list ,int depth){
        if(root==null)
            return ;
        if(depth==list.size()){
            list.add(root.val);
        }
        depth++;
        dfs(root.right,list,depth);
        dfs(root.left,list,depth);        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,null,5,null,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,null,null,null,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

