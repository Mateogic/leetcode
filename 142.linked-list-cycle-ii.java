/*
 * @lc app=leetcode.cn id=142 lang=java
 * @lcpr version=30204
 *
 * [142] 环形链表 II
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
// 假设环外长度为a，slow入环后又经过长度为b(环的剩余长度为c，总计b+c)与fast相遇
// 任意时刻，fast走过的长度是slow的二倍，假设此时fast已经走过n圈环
// 2a+2b = a+(b+c)n+b -> a = (n-1)(b+c)+c
// 化简后的公式意为：从起点到入环点的距离(a)等于从相遇点到入环点的距离(c)+n-1圈环长
// 因此，在slow和fast相遇时，在起点新加指针ptr和slow一样每次一步，二者最终将在入环点相遇
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null || head.next ==null) {
            return null;
        }
        ListNode ptr = head,slow = head, fast = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast==slow) {
                while (ptr!=slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
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

