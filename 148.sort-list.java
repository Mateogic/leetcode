/*
 * @lc app=leetcode.cn id=148 lang=java
 * @lcpr version=30204
 *
 * [148] 排序链表
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
// 自顶向下归并排序，空间复杂度需要O(nlogn)的栈开销
// 自底向上归并排序，空间复杂度为O(1)
class Solution {
    public ListNode sortList(ListNode head) {
        int len = getListLength(head);
        ListNode dummy = new ListNode(0,head);
        for(int size = 1;size < len;size*=2){
            ListNode newTail = dummy;// 已合并链表的尾节点
            ListNode cur = dummy.next;// 每轮循环的起点
            while (cur!=null) {// 将原链表分割成若干长度为size的链表，然后合并
                // 从cur开始，分割出两段长为size的链表，头节点分别为head1和head2
                ListNode head1 = cur, head2 = splitList(head1, size);
                cur = splitList(head2, size);// 分割第二段与后续节点的连接，并更新下一轮的起始节点
                // 合并两段长为size的链表
                ListNode[] merged = mergeLists(head1, head2);
                newTail.next = merged[0];// 将排好序的链表头节点拼接到已合并链表的后面
                newTail = merged[1];// 更新已排好序的链表的尾节点
            }
        }
        return dummy.next;
    }
    // // 获取链表长度
    private int getListLength(ListNode head){
        int len = 0;
        for(ListNode cur = head;cur!=null;cur = cur.next)
            len++;
        return len;
    }

    // 分割链表
    // 若链表长度<=size，不做操作，返回空节点
    // 若链表长度>size，将前size个节点分割出来(断开连接)，并返回剩余链表的头节点
    private ListNode splitList(ListNode head, int size){
        ListNode cur = head;
        // 先找到nextHead的前一个节点，即链表分割后前段链表的尾节点
        for (int i = 0; i < size-1 && cur!=null; i++) {
            cur = cur.next;
        }
        if (cur == null || cur.next==null)// 链表长度<=size
            return null; 
        ListNode nextHead = cur.next;
        cur.next = null;// 断开连接
        return nextHead;
    }

    // 合并两个有序链表，返回合并后链表的头和尾节点
    // 头节点用于连接到已合并的链表，尾节点用于更新已合并链表的尾节点，用于连接后续排好序的链表
    private ListNode[] mergeLists(ListNode list1, ListNode list2){
        ListNode dummy = new ListNode(0), cur = dummy;
        while (list1!=null && list2!=null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1!=null?list1:list2;// 拼接剩余链表
        while (cur.next!=null) {// 找到合并后链表的尾节点
            cur = cur.next;
        }
        return new ListNode[]{dummy.next, cur};
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1,5,3,4,0]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

