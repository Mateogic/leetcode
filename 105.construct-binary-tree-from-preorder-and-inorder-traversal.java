/*
 * @lc app=leetcode.cn id=105 lang=java
 * @lcpr version=30204
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
// 前序遍历数组的第 1 个数（索引为 0）一定是二叉树的根结点，于是可以在中序遍历中找这个根结点的索引
// 然后把“前序遍历数组”和“中序遍历数组”各自分为两个部分，分别对应二叉树的左子树和右子树，之后分别递归
// 前序preleft(pivot), [preleft+1, ... , x=pivotidx-inleft+preleft] [pivotidx-inleft+preleft+1, ..., preright]
// 中序[inleft, ... , pivotidx-1] pivotidx [pivotidx+1, ... , inright]
// 计算x: x-preleft = pivotidx-inleft -> x = pivotidx-inleft+preleft
// 方案一：遍历找到pivotidx，时间复杂度O(N^2)
// 方案二：哈希表找到pivotidx，时间复杂度O(N)

class Solution {
    // 哈希表构建索引
    private Map<Integer, Integer> hash;// 中序遍历的(值,索引)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 方案二:哈希表构建索引
        this.hash = new HashMap<>();
        for(int i = 0;i<inorder.length;i++){
            hash.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    private TreeNode build(int[] preorder, int preleft, int preright,
                           int[] inorder, int inleft, int inright){
        if (preleft > preright || inleft > inright) // 递归终止条件
            return null;
        int pivot = preorder[preleft];
        TreeNode root = new TreeNode(pivot);// 以前序遍历的第一个元素作为根节点

        // 方案一
        // int pivotidx = inleft;
        // while (inorder[pivotidx] != pivot) // 找到根节点在中序遍历中的索引
        //     pivotidx++;
        
        // 方案二
        int pivotidx = hash.get(pivot);
        // 根据中序遍历中左子树和右子树的长度，反推前序遍历中左子树和右子树的边界
        root.left = build(preorder, preleft+1, pivotidx-inleft+preleft, inorder, inleft, pivotidx-1);// 递归构建左子树
        root.right = build(preorder, pivotidx-inleft+preleft+1, preright, inorder, pivotidx+1, inright);// 递归构建右子树
        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,9,20,15,7]\n[9,3,15,20,7]\n
// @lcpr case=end

// @lcpr case=start
// [-1]\n[-1]\n
// @lcpr case=end

 */

