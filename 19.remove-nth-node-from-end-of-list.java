/*
 * @lc app=leetcode.cn id=19 lang=java
 * @lcpr version=30204
 *
 * [19] 删除链表的倒数第 N 个结点
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
// 快慢指针
// 当fast移动到null时，slow应该移动到倒数第n个的前一个，即倒数第n+1个
// 而从倒数第n+1移动到null需要跳n+1次，所以fast先走n+1次，然后slow出发
// 但在fast移动n+1的时候，可能会越界访问，所以应该先走n次
// 并且，如果删除头节点可能会返回null等难以处理的情况
// 引入slow=dummy.next = head节点，这样fast领先slow n次，slow即可到达倒数第n+1个节点
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode fast = head, slow = dummy;
        for (int i = 0; i < n; i++) {// 多走n次
            fast = fast.next;
        }
        while (fast!=null) {// 出循环后 fast = null， slow = n+1
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;// 删除slow之后的节点
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n
// @lcpr case=end

 */

