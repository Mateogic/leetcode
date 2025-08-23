/*
 * @lc app=leetcode.cn id=35 lang=java
 * @lcpr version=30204
 *
 * [35] 搜索插入位置
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1, mid = 0, res = -1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] >= target){
                res = mid;
                right = mid-1;
            }
            else
                left = mid +1;
        }
        return res==-1?nums.length:res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,5,6]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n7\n
// @lcpr case=end

 */

