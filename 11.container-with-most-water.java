/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30204
 *
 * [11] 盛最多水的容器
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int res = 0;
        while (left< right) {
            int area = (right-left) * Math.min(height[left], height[right]);
            res = Math.max(area, res);
            if (height[left] <= height[right]) 
                left++;
            else
                right--;
        }
        return res;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,1]\n
// @lcpr case=end

 */

