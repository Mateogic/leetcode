/*
 * @lc app=leetcode.cn id=104 lang=java
 * @lcpr version=30204
 *
 * [104] 二叉树的最大深度
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
    // DFS递归实现(后序) 时空复杂度O(N)
    // 树的深度 等于 左子树的深度 与 右子树的深度中的 最大值 +1
    // public int maxDepth(TreeNode root) {
    //     if(root==null)
    //         return 0;
    //     return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    // }

    // BFS实现(层序) 时空复杂度O(N)
    // 每遍历一层，计数器+1
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {// 每次while循环处理存储在队列的一层节点
            res ++;
            // 每次for循环处理队列中的一个节点
            for(int i = queue.size();i>0;i--){// 倒序遍历，否则size会因多次调用改变取值
                TreeNode node = queue.poll();
                if(node.left!=null)
                    queue.offer(node.left);// 将下一层的非空节点入队
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,null,null,15,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,null,2]\n
// @lcpr case=end

 */

