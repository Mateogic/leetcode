/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=30204
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 等价于找大于等于 target 的最左位置和大于等于 target+1 的最左位置 - 1
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0)// 数组为空
            return new int[]{-1,-1};
        int left = bindSearchLeft(nums, target);
        if(left == nums.length || nums[left]!=target)// 数组所有元素均小于target会导致nums[left]越界
            return new int[]{-1,-1};
        int right = bindSearchLeft(nums, target+1)-1;
        return new int[]{left,right};
    }
    public int bindSearchLeft(int[] nums, int target){
        int left = 0, right = nums.length-1, mid = 0, res = -1;
        while(left <= right){
            mid = left + (right-left)/2;
            if(nums[mid] >= target){
                res = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return res==-1?nums.length:res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,7,7,8,8,10]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,7,7,8,8,10]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */

