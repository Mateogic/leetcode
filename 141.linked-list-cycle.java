/*
 * @lc app=leetcode.cn id=141 lang=java
 * @lcpr version=30204
 *
 * [141] 环形链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// 快慢指针
// 前提：若链表中不存在环，则快指针将会领先慢指针到达null
// 如果链表中存在环，则遍历过程中快慢指针只能在环上绕圈，不会到达null



// 判断fast.next是否为null的目的：fast.next.next是否可达
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,0,-4]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [1]\n-1\n
// @lcpr case=end

 */

