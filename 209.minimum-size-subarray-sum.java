/*
 * @lc app=leetcode.cn id=209 lang=java
 * @lcpr version=30204
 *
 * [209] 长度最小的子数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE;
        for(;right < nums.length;right++){
            sum += nums[right];
            while(sum >= target){
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 7\n[2,3,1,2,4,3]\n
// @lcpr case=end

// @lcpr case=start
// 4\n[1,4,4]\n
// @lcpr case=end

// @lcpr case=start
// 11\n[1,1,1,1,1,1,1,1]\n
// @lcpr case=end

 */

