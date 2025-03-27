/*
 * @lc app=leetcode.cn id=206 lang=java
 * @lcpr version=30204
 *
 * [206] 反转链表
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
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;// pre到达最后一个元素
            cur = next;// cur到达null
        }
        return pre;// 返回pre
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

