/*
 * @lc app=leetcode.cn id=106 lang=java
 * @lcpr version=30204
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.HashMap;

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
// 后序遍历数组的最后 1 个数（索引为 length-1）一定是二叉树的根结点，于是可以在中序遍历中找这个根结点的索引
// 然后把“后序遍历数组”和“中序遍历数组”各自分为两个部分，分别对应二叉树的左子树和右子树，之后分别递归
// 后序[postleft, postleft+1, ... , ] [x=postright - inright + pivotidx, ..., postright-1], postright(pivot)
// 中序[inleft, ... , pivotidx-1] pivotidx [pivotidx+1, ... , inright]
// 计算x: postright-x = inright - pivotidx -> x = postright - inright + pivotidx
// 方案一：遍历找到pivotidx，时间复杂度O(N^2)
// 方案二：哈希表找到pivotidx，时间复杂度O(N)
class Solution {
    private HashMap<Integer, Integer> hash;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.hash = new HashMap<>();
        for(int i = 0;i<inorder.length;i++)// 用于查询pivot对应的pivotidx
            hash.put(inorder[i], i);
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode build(int[] inorder, int inleft, int inright, 
                           int[] postorder, int postleft, int postright){
        if (inleft > inright || postleft > postright) // 递归终止条件
            return null;
        int pivot = postorder[postright];
        TreeNode root = new TreeNode(pivot);
        // 方案一
        // int pivotidx = inleft;
        // while (inorder[pivotidx]!=pivot) 
        //     pivotidx++;

        // 方案二
        int pivotidx = hash.get(pivot);
        root.left = build(inorder, inleft, pivotidx-1, postorder, postleft, postright - inright + pivotidx-1);
        root.right = build(inorder, pivotidx+1, inright, postorder, postright - inright + pivotidx, postright-1);
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [9,3,15,20,7]\n[9,15,7,20,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n[-1]\n
// @lcpr case=end

 */

