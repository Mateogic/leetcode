/*
 * @lc app=leetcode.cn id=92 lang=java
 * @lcpr version=30204
 *
 * [92] 反转链表 II
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 创建虚拟节点，应对反转head的情况
        ListNode dummy = new ListNode(0,head);
        // p0放在该段链表的前一个节点处，用于处理反转后该段链表与前后的连接关系
        ListNode p0 = dummy;
        // 找到要反转链表段的第一个节点
        for (int i = 1; i < left; i++)
            p0 = p0.next;
        ListNode cur = p0.next,pre = null,next = null;// cur指向该段链表的第一个节点
        // 反转次数等于该段链表的节点数量
        for(int i = 0;i< right-left+1;i++){// 该段链表的节点数量为r-l+1
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }// 反转后，cur指向该段链表的后一个节点，pre指向该段链表的新头节点
        // 处理反转后该段链表与前后的连接关系
        p0.next.next = cur;
        p0.next = pre;
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n4\n
// @lcpr case=end

// @lcpr case=start
// [5]\n1\n1\n
// @lcpr case=end

 */

