/*
 * @lc app=leetcode.cn id=713 lang=java
 * @lcpr version=30204
 *
 * [713] 乘积小于 K 的子数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
            return 0;
        int left = 0, right = 0, prod = 1, res = 0;
        for(;right < nums.length;right++){
            prod *= nums[right];
            while(prod >= k){
                prod /=nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [10,5,2,6]\n100\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n0\n
// @lcpr case=end

 */

