/*
 * @lc app=leetcode.cn id=162 lang=java
 * @lcpr version=30204
 *
 * [162] 寻找峰值
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        int n = nums.length;
        if(nums[n-1] > nums[n-2])
            return n-1;
        int l = 1, r = n-2, res = -1, m = 0;
        while(l <= r){
            m = l + ((r-l)>>1);
            if(nums[m] < nums[m-1])
                r = m-1;
            else if(nums[m] < nums[m+1])
                l = m+1;
            else{
                res = m;
                break;
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,1,3,5,6,4]\n
// @lcpr case=end

 */

