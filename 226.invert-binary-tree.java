/*
 * @lc app=leetcode.cn id=226 lang=java
 * @lcpr version=30204
 *
 * [226] 翻转二叉树
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
// 对于根节点，它的左右儿子必须交换，即左儿子变成右儿子，右儿子变成左儿子。
// 对于根节点的左右子树，也需要翻转其内部节点。这是一个和原问题相似的子问题，可以用递归解决。
// 递归的边界条件:空节点返回null
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        TreeNode left = invertTree(root.left);// 递归处理root的左右子树
        TreeNode right = invertTree(root.right);
        root.left = right;// 处理root的左右子节点
        root.right = left;
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,7,1,3,6,9]\n
// @lcpr case=end

// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

