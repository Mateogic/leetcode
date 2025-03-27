/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30204
 *
 * [239] 滑动窗口最大值
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 单调队列
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];// 滑动窗口数量，也是每个滑动窗口的左边界索引
        Deque<Integer> dq = new LinkedList<Integer>();// 双端单调队列
        for(int i = 0;i<k;i++){// 先把[0,k-1]这k个元素放入队列
            while(!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) // 队列非空且新元素大于等于队尾元素
                dq.pollLast();
            dq.offerLast(i);
        }
        res[0] = nums[dq.peekFirst()];
        for(int i = k;i<n;i++){// 枚举滑动窗口的右边界i，对应左边界为i-k+1
            while (!dq.isEmpty() && nums[i]>=nums[dq.peekLast()]) 
                dq.pollLast();
            dq.offerLast(i);
            if (dq.peekFirst() < i-k+1) // 超出左边界
                dq.pollFirst();
            res[i-k+1] = nums[dq.peekFirst()];
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,-1,-3,5,3,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

