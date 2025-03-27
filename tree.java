import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class tree {
    // 定义二叉树
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 主函数
    public static void main(String[] args) {
        // 快速构造层序遍历列表
        List<Integer> levelOrder = new ArrayList<>(
            Arrays.asList(0, 1, 2, 3, 4, 5, 6)// 完全二叉树
            // Arrays.asList(1, 2, null, 3, 4, null, null, 5)// 不平衡二叉树
        );
        TreeNode root = build(levelOrder);// 层序遍历构造二叉树

        // 递归版前序遍历
        List<Integer> res1 = new ArrayList<>();
        preorder_recursion(root,res1);
        System.out.println("前序遍历(递归):"+res1);
        // 迭代版前序遍历
        List<Integer> res2 = new ArrayList<>();
        preorder_iteration(root, res2);
        System.out.println("前序遍历(迭代):"+res2);
        // Morris版前序遍历
        // List<Integer> pre_res_morris = new ArrayList<>();
        // preorder_iteration(root, pre_res_morris);
        // System.out.println("前序遍历(Morris):"+pre_res_morris+"\n====================");

        // 递归版中序遍历
        List<Integer> res3 = new ArrayList<>();
        inorder_recursion(root,res3);
        System.out.println("中序遍历(递归):"+res3);
        // 迭代版中序遍历
        List<Integer> res4 = new ArrayList<>();
        inorder_iteration(root, res4);
        System.out.println("中序遍历(迭代):"+res4);
        // // Morris版中序遍历
        // List<Integer> in_res_morris = new ArrayList<>();
        // inorder_iteration(root, in_res_morris);
        // System.out.println("中序遍历(Morris):"+in_res_morris+"\n====================");

        // 递归版后序遍历
        List<Integer> res5 = new ArrayList<>();
        postorder_recursion(root,res5);
        System.out.println("后序遍历(递归):"+res5);
        // 迭代版后序遍历
        List<Integer> res6 = new ArrayList<>();
        postorder_iteration(root, res6);
        System.out.println("后序遍历(迭代):"+res6);


        // 迭代版后序遍历
        List<List<Integer>> level_res = new ArrayList<>();
        levelorder_queue(root, level_res);
        System.out.println("层序遍历:"+level_res);
    }

    // 根据一维的层序遍历列表(用null表示空节点)构造二叉树，返回根节点
    // 利用数组的索引关系实现，若根节点索引为0，那么节点i的左子节点为2i+1，右子节点为2i+2
    private static TreeNode build(List<Integer> levelOrder){
        if (levelOrder==null || levelOrder.isEmpty() || levelOrder.get(0)==null) 
            return null;
        // 创建所有节点
        List<TreeNode> nodes = new ArrayList<>(levelOrder.size());
        for(Integer val : levelOrder){
            if(val!=null)
                nodes.add(new TreeNode(val));
            else
                nodes.add(null);
        }

        // 根据索引关系构造二叉树
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            TreeNode cur = nodes.get(i);
            if (cur!=null) {// 仅非空节点才有子节点
                int leftidx = 2*i+1;// 左子节点索引
                int rightidx = 2*i+2;// 右子节点索引
                if(leftidx < size)
                    cur.left = nodes.get(leftidx);// nodes.get(leftidx)可能为null
                if(rightidx < size)
                    cur.right = nodes.get(rightidx);
            }
        }
        return nodes.get(0);
    }

    // 深度优先搜索(DFS、栈)
    // 二叉树的前序遍历(递归)lc144
    private static void preorder_recursion(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        res.add(root.val);
        preorder_recursion(root.left, res);
        preorder_recursion(root.right, res);
    }
    // 二叉树的前序遍历(迭代)
    // 前序遍历的访问顺序和处理顺序一致
    private static void preorder_iteration(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.right!=null)
                stk.push(node.right);
            if (node.left!=null)
                stk.push(node.left);
        }
    }
    // 二叉树的前序遍历(Morris)



    // 二叉树的中序遍历(递归)lc94
    private static void inorder_recursion(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        inorder_recursion(root.left, res);
        res.add(root.val);
        inorder_recursion(root.right, res);
    }
    // 二叉树的中序遍历(迭代)
    private static void inorder_iteration(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        Stack<TreeNode> stk = new Stack<>();
        TreeNode cur = root;
        while (!stk.isEmpty() || cur!=null) {
            while (cur!=null) {
                stk.push(cur);
                cur = cur.left;
            }// 栈顶元素为最左下角的节点
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.right!=null)
                cur = node.right;
        }
    }
    // 二叉树的中序遍历(Morris)



    // 二叉树的后序遍历(递归)lc145
    private static void postorder_recursion(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        postorder_recursion(root.left, res);
        postorder_recursion(root.right, res);
        res.add(root.val);
    }
    // 二叉树的后序遍历(迭代)
    // 前序(中左右) -> 调换入栈顺序(中右左) -> 翻转 -> 后序(左右中)
    private static void postorder_iteration(TreeNode root, List<Integer> res){
        if(root==null)
            return ;
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.left!=null)
                stk.push(node.left);
            if (node.right!=null) 
                stk.push(node.right);
        }
        // 翻转
        Collections.reverse(res);
    }
    // 二叉树的后序遍历(Morris)

    // 广度优先搜索(BFS、队列)
    // 二叉树的层序遍历
    private static void levelorder_queue(TreeNode root, List<List<Integer>> res){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size();i>0;i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            res.add(tmp);
        }
    }
}
