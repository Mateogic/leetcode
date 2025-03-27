/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30204
 *
 * [234] 回文链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
// 复制到list判断
// get equals size
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 复制到list
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur!=null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int l = 0,r = list.size()-1;
        while (l<r) {
            if (list.get(l)!=list.get(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

