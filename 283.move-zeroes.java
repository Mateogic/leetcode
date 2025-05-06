/*
 * @lc app=leetcode.cn id=283 lang=java
 * @lcpr version=30204
 *
 * [283] 移动零
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, len = nums.length;
        while (right < len) {
            if (nums[right]!=0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
            }
            right++;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,3,12]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

