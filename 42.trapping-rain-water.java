/*
 * @lc app=leetcode.cn id=42 lang=java
 * @lcpr version=30204
 *
 * [42] 接雨水
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        while (left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax <= rightMax) {
                res+=leftMax - height[left];
                left++;
            }
            else{
                res+=rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,2,1,0,1,3,2,1,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [4,2,0,3,2,5]\n
// @lcpr case=end

 */

