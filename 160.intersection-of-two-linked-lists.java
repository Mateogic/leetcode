/*
 * @lc app=leetcode.cn id=160 lang=java
 * @lcpr version=30204
 *
 * [160] 相交链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 假设A链表长度为m=a+c（A从第一个节点遍历到null需要m次），B链表长度为n=b+c（同理遍历需要n次）
// 遍历过程中，到达null之后的下次遍历跳到另一个链表的头节点
// 若两链表存在交点，a+c+b = b+c+a，按照上述规则遍历二者终将在交点相遇
// 若二者不存在交点，m+n=n+m，按照上述规则遍历二者终将在null相遇
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;
        while (pa!=pb) {
            pa=pa==null?headB:pa.next;
            pb=pb==null?headA:pb.next;
        }
        return pa;// 返回相交节点
    }
}
// @lc code=end



/*
// @lcpr case=start
// 8\n[4,1,8,4,5]\n[5,6,1,8,4,5]\n2\n3\n
// @lcpr case=end

// @lcpr case=start
// 2\n[1,9,1,2,4]\n[3,2,4]\n3\n1\n
// @lcpr case=end

// @lcpr case=start
// 0\n[2,6,4]\n[1,5]\n3\n2\n
// @lcpr case=end

 */

