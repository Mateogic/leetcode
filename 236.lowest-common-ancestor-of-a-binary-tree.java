/*
 * @lc app=leetcode.cn id=236 lang=java
 * @lcpr version=30204
 *
 * [236] 二叉树的最近公共祖先
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 方法的目标是找到以root为根节点的树中，p、q节点的最近公共祖先，包括以下三种返回情况
        // 若p和q都存在于此树上，则此树上一定存在它们的最近公共祖先，返回该祖先
        // 若p、q之一存在于此树上，则返回存在者的最近祖先(自身)
        // 若p、q都不存在于此树上，则返回null
    // 递归处理，向下寻找以不同节点为根的子树中是否存在p、q的最近公共祖先
    // 因为是递归，使用函数后可认为左右子树已经算出结果
    // left标记root的左子树是否存在pq的公共祖先，right标记root的右子树是否存在pq的公共祖先
    // 分为以下情况
        // 1. left和right都非空，那么left和right分别为p或q节点自身，二者在root的异侧子树，返回root
        // 2. left和right都为空，那么root的左右子树都没有pq节点，返回null
        // 3. left非空，right为空，那么pq都在root的左子树上，返回值left即它们的最近公共祖先
        // 4. left为空，right非空，那么pq都在root的右子树上，返回值right即它们的最近公共祖先
    
    // 递归的边界条件
        // root==null || root==p || root==q -> return root;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 2
        if(left == null) return right; // 3
        if(right == null) return left; // 4
        return root; // 1 left != null and right != null
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n1\n
// @lcpr case=end

// @lcpr case=start
// [3,5,1,6,2,0,8,null,null,7,4]\n5\n4\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n2\n
// @lcpr case=end

 */

