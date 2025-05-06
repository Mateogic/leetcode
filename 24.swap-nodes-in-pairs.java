/*
 * @lc app=leetcode.cn id=24 lang=java
 * @lcpr version=30204
 *
 * [24] 两两交换链表中的节点
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
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
// tmp(dummy) -> node1 -> node2s -> node3 -> node4
// dummy -> node2 -> node1(tmp) -> node3 -> node4
// dummy -> node2 -> node1 -> node4 -> node3(tmp)
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode tmp = dummy;
        while (tmp.next!=null && tmp.next.next!=null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;// 改变dummy和tmp的指向
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

