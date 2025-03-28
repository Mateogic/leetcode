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
        System.out.println("====================");


        // 递归版中序遍历
        List<Integer> res3 = new ArrayList<>();
        inorder_recursion(root,res3);
        System.out.println("中序遍历(递归):"+res3);
        // 迭代版中序遍历
        List<Integer> res4 = new ArrayList<>();
        inorder_iteration(root, res4);
        System.out.println("中序遍历(迭代):"+res4);
        System.out.println("====================");


        // 递归版后序遍历
        List<Integer> res5 = new ArrayList<>();
        postorder_recursion(root,res5);
        System.out.println("后序遍历(递归):"+res5);
        // 迭代版后序遍历
        List<Integer> res6 = new ArrayList<>();
        postorder_iteration(root, res6);
        System.out.println("后序遍历(迭代):"+res6);
        System.out.println("====================");


        // 层序遍历
        List<List<Integer>> level_res = new ArrayList<>();
        levelorder_queue(root, level_res);
        System.out.println("层序遍历:"+level_res);
        System.out.println("====================");


        // Morris序
        List<Integer> morris_res = new ArrayList<>();
        morris(root,morris_res);
        System.out.println("Morris顺序:"+morris_res);// [0, 1, 3, 1, 4, 0, 2, 5, 2, 6]
        // 对于有左子树的节点，会被访问两次，否则访问一次
        // 前序遍历(Morris)
        List<Integer> morris_pre_res = new ArrayList<>();
        morrisPreorder(root,morris_pre_res);
        System.out.println("前序遍历(Morris):"+morris_pre_res);
        // 中序遍历(Morris)
        List<Integer> morris_in_res = new ArrayList<>();
        morrisInorder(root,morris_in_res);
        System.out.println("中序遍历(Morris):"+morris_in_res);
    }

    // 根据一维的层序遍历列表(用null表示空节点)构造二叉树，返回根节点
    // 利用数组的索引关系实现，若根节点索引为0，那么节点i的左子节点为2i+1，右子节点为2i+2
    private static TreeNode build(List<Integer> levelOrder){
        if (levelOrder==null || levelOrder.isEmpty() || levelOrder.get(0)==null) 
            return null;
        // 创建所有节点
        int size  = levelOrder.size();
        List<TreeNode> nodes = new ArrayList<>(size);
        for(Integer val : levelOrder){
            if(val!=null)
                nodes.add(new TreeNode(val));
            else
                nodes.add(null);
        }

        // 根据索引关系构造二叉树
        for (int i = 0; i < size; i++) {
            TreeNode cur = nodes.get(i);
            if (cur!=null) {// 仅非空节点才有子节点
                int leftidx = 2*i+1;// 左子节点索引
                int rightidx = 2*i+2;// 右子节点索引
                if(leftidx < size)
                    cur.left = nodes.get(leftidx);// 左右子节点可能为null
                if(rightidx < size)
                    cur.right = nodes.get(rightidx);
            }
        }
        return nodes.get(0);// 返回构造二叉树的头节点
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
            if(node.right!=null)// 压栈顺序与出栈顺序相反
                stk.push(node.right);
            if (node.left!=null)
                stk.push(node.left);
        }
    }

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
            }// 持续将左子树的左孩子压栈，栈顶为最左下角的节点
            TreeNode node = stk.pop();
            res.add(node.val);
            if(node.right!=null)// 弹栈返回上层，尝试处理右子树
                cur = node.right;
        }
    }

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
    // 广度优先搜索(BFS、队列)
    // 二叉树的层序遍历
    private static void levelorder_queue(TreeNode root, List<List<Integer>> res){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.offer(root);
        while (!queue.isEmpty()) {// 每次while循环处理存储在队列的一层节点
            List<Integer> tmp = new ArrayList<>();
            // 每次for循环处理队列中的一个节点
            for(int i = queue.size();i>0;i--){// 倒序遍历，否则size会因多次调用改变取值
                TreeNode node = queue.poll();
                tmp.add(node.val);// 将本层的节点加到tmp
                if(node.left!=null)
                    queue.offer(node.left);// 将下一层的非空节点入队
                if(node.right!=null)
                    queue.offer(node.right);
            }
            res.add(tmp);// 添加各层的遍历结果
        }
    }

    // Morris顺序:0 1 3 1 4 0 2 5 2 6
    // 对于有左子树的节点，会被访问两次，否则访问一次
    private static void morris(TreeNode root, List<Integer> res){
        if (root == null) 
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;// 左子树的最右节点
        while (cur != null) {
            res.add(cur.val);// 处理节点前加入列表
            mostRight = cur.left;
            if (mostRight != null) { // cur有左树
                // 找到左树最右节点
                // 注意左树最右节点的右指针可能指向空，也可能指向cur
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 判断左树最右节点的右指针状态
                if (mostRight.right == null) { // 第一次到达(指向null)
                    mostRight.right = cur;// 改变指向到cur
                    cur = cur.left;// cur左移
                    continue;
                } else { // 第二次到达(指向cur)
                    mostRight.right = null;// 改回指向到null
                    cur = cur.right;// cur右移
                }
            }
            else// cur无左树，cur右移
                cur = cur.right;
        }
    }

    // 前序遍历(Morris)
    // 无左树收集，第一次到达收集，第二次到达不收集
    private static void morrisPreorder(TreeNode root, List<Integer> res){
        if (root == null) 
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;// 左子树的最右节点
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // cur有左树
                // 找到左树最右节点
                // 注意左树最右节点的右指针可能指向空，也可能指向cur
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 判断左树最右节点的右指针状态
                if (mostRight.right == null) { // 第一次到达(指向null)
                    res.add(cur.val);
                    mostRight.right = cur;// 改变指向到cur
                    cur = cur.left;// cur左移
                    continue;
                } else { // 第二次到达(指向cur)
                    mostRight.right = null;// 改回指向到null
                    cur = cur.right;// cur右移
                }
            }
            else{// cur无左树，cur右移
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }

    // 中序遍历(Morris)
    // 无左树收集，第二次到达收集，第一次到达不收集
    private static void morrisInorder(TreeNode root, List<Integer> res){
        if (root == null) 
            return;
        TreeNode cur = root;
        TreeNode mostRight = null;// 左子树的最右节点
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) { // cur有左树
                // 找到左树最右节点
                // 注意左树最右节点的右指针可能指向空，也可能指向cur
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                // 判断左树最右节点的右指针状态
                if (mostRight.right == null) { // 第一次到达(指向null)
                    mostRight.right = cur;// 改变指向到cur
                    cur = cur.left;// cur左移
                    continue;
                } else { // 第二次到达(指向cur)
                    res.add(cur.val);
                    mostRight.right = null;// 改回指向到null
                    cur = cur.right;// cur右移
                }
            }
            else{// cur无左树，cur右移
                res.add(cur.val);
                cur = cur.right;
            }
        }
    }
}
