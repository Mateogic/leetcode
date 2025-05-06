/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=30204
 *
 * [2] 两数相加
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
// 模拟
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head= null,tail = null;
        while (l1!=null || l2!=null) {
            int n1 = l1!=null?l1.val:0;            
            int n2 = l2!=null?l2.val:0;
            int sum = n1+n2+carry;
            if (head == null) {
                tail = new ListNode(sum%10);// 建立head与tail的关系
                head = tail;
            }
            else{
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if (l1!=null) {
                l1 = l1.next;
            }
            if (l2!=null) {
                l2 = l2.next;
            }
        }
        if (carry!=0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n
// @lcpr case=end

// @lcpr case=start
// [9,9,9,9,9,9,9]\n[9,9,9,9]\n
// @lcpr case=end

 */

