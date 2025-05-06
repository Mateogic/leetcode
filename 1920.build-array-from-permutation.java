/*
 * @lc app=leetcode.cn id=1920 lang=java
 * @lcpr version=30204
 *
 * [1920] 基于排列构建数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0;i<n;i++)
            res[i] = nums[nums[i]];
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,2,1,5,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [5,0,1,2,3,4]\n
// @lcpr case=end

 */

