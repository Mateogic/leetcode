/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30204
 *
 * [25] K 个一组翻转链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// lc206反转链表:任意一段链表反转之后，pre指针指向头节点(该段链表原本最后的节点)，cur指向pre之后的一个节点
// k个一组反转链表:将原本一段链表之前的一个节点记作p0，反转之后应该有p0.next = pre
// 反转操作之后，p0之后的一个节点应该指向cur，即p0.next.next = cur

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表节点数量
        int n = 0;
        for(ListNode cur = head;cur!=null;cur = cur.next)
            n++;
        ListNode dummy = new ListNode(0,head);
        ListNode p0 = dummy, pre = null, cur = head;
        while (n>=k) {
            n-=k;
            for (int i = 0; i < k; i++) {// 反转k个节点一段的链表
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            // 处理反转后该段链表与前后的连接关系
            ListNode nxt = p0.next;
            p0.next.next = cur;
            p0.next = pre;
            p0 = nxt;// 更新p0到下一段k个节点一段链表的前一个节点位置
        }
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n3\n
// @lcpr case=end

 */

