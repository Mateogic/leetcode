/*
 * @lc app=leetcode.cn id=21 lang=java
 * @lcpr version=30204
 *
 * [21] 合并两个有序链表
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
// 迭代
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode l1 = list1, l2 = list2, pre = new ListNode(-1);
//         ListNode prehead = pre;
//         while (l1!=null && l2!=null) {
//             if (l1.val<=l2.val) {
//                 pre.next = l1;
//                 l1 = l1.next;
//             }
//             else{
//                 pre.next = l2;
//                 l2 = l2.next;
//             }
//             pre = pre.next;
//         }
//         pre.next = l1!=null?l1:l2;
//         return prehead.next;
//     }
// }

// 递归
class Solution{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if (list1==null) {
            return list2;
        }
        else if (list2==null) {
            return list1;
        }
        else if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else{
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,4]\n[1,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n[]\n
// @lcpr case=end

// @lcpr case=start
// []\n[0]\n
// @lcpr case=end

 */

