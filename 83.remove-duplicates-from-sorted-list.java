/*
 * @lc app=leetcode.cn id=83 lang=java
 * @lcpr version=30204
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            if(cur.next.val==cur.val)// 判断是否要删除下个节点
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,2]\n
// @lcpr case=end

// @lcpr case=start
// [1,1,2,3,3]\n
// @lcpr case=end

 */

