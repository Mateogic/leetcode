/*
 * @lc app=leetcode.cn id=23 lang=java
 * @lcpr version=30204
 *
 * [23] 合并 K 个升序链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.PriorityQueue;

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
// 合并链表的第一个节点一定是某个链表的头节点
// 后续的其它节点，可能是某个链表的头节点，也可能是各个链表后续的节点
// 因此，假设找到k个链表当前最小的节点x，需要进一步考虑x.next和其它链表最小节点的大小关系
// 构建最小堆，初始将所有链表的头节点加入，在弹出最小节点x的同时，尝试加入x.next(非null)
// 将弹出的节点按照顺序拼接，循环直至空堆
// 虽然没有让null入堆，但此处通过取出节点引用而非创建节点方式，保持所有原链表尾节点指向null不变
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 定义最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode head:lists){// 将所有非空链表的头节点入堆
            if (head!=null) {
                pq.offer(head);
            }
        }
        ListNode dummy = new ListNode(0), cur = dummy;
        while (!pq.isEmpty()) {// 循环直至空堆
            ListNode node = pq.poll();// 弹出最小节点
            if (node.next!=null)// 尝试将最小节点的next入堆
                pq.offer(node.next); 
            cur.next = node;// 拼接最小节点
            cur = cur.next;
        }
        return dummy.next;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,4,5],[1,3,4],[2,6]]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [[]]\n
// @lcpr case=end

 */

