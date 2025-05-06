/*
 * @lc app=leetcode.cn id=189 lang=java
 * @lcpr version=30204
 *
 * [189] 轮转数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 数组翻转
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums,int start, int end){// 翻转数组的[start,end]区间元素
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [-1,-100,3,99]\n2\n
// @lcpr case=end

 */

