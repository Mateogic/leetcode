/*
 * @lc app=leetcode.cn id=53 lang=java
 * @lcpr version=30204
 *
 * [53] 最大子数组和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 前缀和
class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int pre = 0, min_pre = 0;
        for(int i = 0;i<nums.length;i++){
            pre+=nums[i];
            // 注意顺序不可交换
            res = Math.max(pre - min_pre, res);// 当前前缀和-前缀和最小值试图更新最大子数组区间
            min_pre = Math.min(min_pre, pre);// 维护前缀和中的最小值
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-2,1,-3,4,-1,2,1,-5,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,-1,7,8]\n
// @lcpr case=end

 */

