/*
 * @lc app=leetcode.cn id=543 lang=java
 * @lcpr version=30204
 *
 * [543] 二叉树的直径
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
// 链：从下面的某个节点（不一定是叶子）到当前节点的路径
// 直径:等价于由两条（或者一条）链拼成的路径
// 在某节点[拐弯]的直径长度=左子树的最长链+右子树的最长链+2
// 返回给父节点的是以当前节点为根的最长链=max(左子树最长链，右子树最长链)+1
// 在计算最长链的同时，顺便计算最长直径

// 因为叶子节点的链长为0，所以空节点的链长为-1(边界条件)
class Solution {
    private int res;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int dfs(TreeNode node){
        if(node == null)// 边界条件:空节点的链长为-1
            return -1;
        int lLen = dfs(node.left);// 左子树链长
        int rLen = dfs(node.right);// 右子树链长
        res = Math.max(res, lLen+rLen+2);// 更新直径
        return Math.max(lLen,rLen)+1;// 返回以node为根的最大链长
    } 
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

