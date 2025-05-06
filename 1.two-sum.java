/*
 * @lc app=leetcode.cn id=1 lang=java
 * @lcpr version=30204
 *
 * [1] 两数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<len;j++){
                if (nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,7,11,15]\n9\n
// @lcpr case=end

// @lcpr case=start
// [3,2,4]\n6\n
// @lcpr case=end

// @lcpr case=start
// [3,3]\n6\n
// @lcpr case=end

 */

