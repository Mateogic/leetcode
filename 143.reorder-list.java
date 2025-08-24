/*
 * @lc app=leetcode.cn id=143 lang=java
 * @lcpr version=30204
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        ListNode mid = midNode(head);
        ListNode head2 = reverseList(mid);
        ListNode cur1 = head, cur2 = head2;
        ListNode next1 = null, next2 = null;
        while(cur2!=null && cur2.next!=null){
            next1 = cur1.next;
            next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;
            cur1 = next1;
            cur2 = next2;
        }
    }
    // 搜索中间节点
    public ListNode midNode(ListNode head){
        ListNode fast = head, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    // 反转链表
    public ListNode reverseList(ListNode head){
        ListNode cur = head, pre = null, next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

 */

