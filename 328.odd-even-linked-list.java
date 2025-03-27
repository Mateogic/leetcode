/*
 * @lc app=leetcode.cn id=328 lang=java
 * @lcpr version=30204
 *
 * [328] 奇偶链表
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
// 拆分奇偶两条链表
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return null;
        ListNode odd = head;
        ListNode even_head = head.next, even = even_head;
        while (odd.next!=null && even.next!=null) {
            // 因奇节点总在偶节点前面，所以此处应该先构造奇链，否则会造成节点丢失问题
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
// 讨论出循环的情况odd.next==null || even.next!=null
    // 若链表有偶数个节点:odd到达倒数第二个节点， even到达倒数第一个节点
    // 若链表有奇数个节点:odd到达倒数第一个节点， even到达null，因此不会形成环
        odd.next = even_head;// 将奇链表的尾节点连到偶链表的头节点
        return head;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [2,1,3,5,6,4,7]\n
// @lcpr case=end

 */

