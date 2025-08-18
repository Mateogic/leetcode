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
        int n = height.length;
        int res = 0;
        int left = 0, right = n-1;
        int pre_max = 0, suf_max = 0;
        while(left < right){
            pre_max = Math.max(pre_max, height[left]);
            suf_max = Math.max(suf_max, height[right]);
            if(pre_max < suf_max){
                res += pre_max - height[left];
                left++;
            }
            else{
                res += suf_max - height[right];
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

