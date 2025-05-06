/*
 * @lc app=leetcode.cn id=108 lang=java
 * @lcpr version=30204
 *
 * [108] 将有序数组转换为二叉搜索树
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
// 有序数组相当于二叉搜索树的中序遍历数组
// 所以本题相当于根据中序遍历数组恢复二叉搜索树
// 又因为要求的是高度平衡的二叉搜索树，所以要以中间元素作为根节点
// 然后以其左侧的元素构造左子树，以右侧的元素构造右子树

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }
    public TreeNode dfs(int[] nums,int l,int r){
        if(l > r)
            return null;
        int mid = (r-l)/2+l;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, l, mid-1);
        root.right = dfs(nums, mid+1, r);
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-10,-3,0,5,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3]\n
// @lcpr case=end

 */

